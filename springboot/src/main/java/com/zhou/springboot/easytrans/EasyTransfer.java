package com.zhou.springboot.easytrans;

import com.zhou.springboot.dao.TestMapper;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//domain service
@Component
public class EasyTransfer {

    public static final Logger log = LoggerFactory.getLogger(EasyTransfer.class);

    @Resource
    private TestMapper testMapper;

    public void transfer(String oldTable, String newTable) {
        //旧表的最大更新时间快照
        Date maxUpdateSnapShot = testMapper.getMaxDate(oldTable);
        Date lastUpdate = testMapper.getMaxDate(newTable);
        if (lastUpdate == null) {
            lastUpdate = defaultDate();
        }
        TransferJob job = new TransferJob(oldTable, lastUpdate);
        log.debug("创建transfer任务" + job);

        job.startTransfer();
        while (!canLockSync(maxUpdateSnapShot, lastUpdate)) {
            //todo: 锁表前可以考虑并发插入
            lastUpdate = transferData(oldTable, newTable, lastUpdate, false);
            log.debug("{}==>transferData成功,lastUpdate设置为{}", job.getJobId(), lastUpdate);
        }

        job.lockTable();
        //锁了表之后需要在特定的时间里切换成功，不然需要超时重试
        Date maxUpdate = testMapper.getMaxDate(oldTable);
        scrumTransfer(job, maxUpdate, lastUpdate, maxUpdateSnapShot, oldTable, newTable);

        String tempTable = oldTable + "$$_temp";
        //        testMapper.unlockTableAndRename(oldTable, tempTable);
        testMapper.unlockTable(oldTable);
        job.unlockTable();

        testMapper.renameTable(oldTable, tempTable);
        testMapper.renameTable(newTable, oldTable);
        testMapper.renameTable(tempTable, newTable);

        job.finish();
    }

    /**
     * 增量transfer
     *
     * @param maxUpdate
     * @param lastUpdate
     * @param maxUpdateSnapShot
     * @param oldTable
     * @param newTable
     */
    public void scrumTransfer(TransferJob job, Date maxUpdate, Date lastUpdate, Date maxUpdateSnapShot, String oldTable,
                              String newTable) {
        while (!canLockSync(maxUpdateSnapShot, lastUpdate)) {
            //不能lock，则继续循环
            log.info("{}==>can't lock.try to transfer again", job.getJobId());
            lastUpdate = transferData(oldTable, newTable, lastUpdate, false);
            log.debug("{}==>transferData成功,lastUpdate设置为{}", job.getJobId(), lastUpdate);
        }

        try {
            testMapper.lockTable(oldTable);
            log.info("{}==>{}表锁成功", job.getJobId(), oldTable);
            while (!transferFinish(maxUpdate, lastUpdate)) {
                lastUpdate = transferData(oldTable, newTable, lastUpdate, true);
                log.debug("{}==>transferData成功,lastUpdate设置为{}", job.getJobId(), lastUpdate);
            }
        } catch (Exception e) {
            log.info("{}==>transferFinish超时", job.getJobId());
            log.info(e.getMessage(), e);
            //超时失败，退回到sync阶段
            testMapper.unlockTable(oldTable);
            log.info("{}==>解除表锁成功", job.getJobId());
            scrumTransfer(job, maxUpdate, lastUpdate, maxUpdateSnapShot, oldTable, newTable);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Date transferData(String oldTable, String newTable, Date lastUpdate, boolean timeout) {
        if (timeout) {
            testMapper.deleteDirty(oldTable, newTable, lastUpdate, TransferConst.TRANSFER_BATCH);
            testMapper.transferDataWithTimeOut(oldTable, newTable, lastUpdate, TransferConst.TRANSFER_BATCH);
        } else {
            testMapper.deleteDirty(oldTable, newTable, lastUpdate, Integer.MAX_VALUE);
            testMapper.transferData(oldTable, newTable, lastUpdate, Integer.MAX_VALUE);
        }
        lastUpdate = testMapper.getMaxDate(newTable);
        return lastUpdate;
    }


    private Date defaultDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970, 1, 1, 0, 0, 0);
        return calendar.getTime();
    }

    private boolean transferFinish(Date maxUpdate, Date processUpdate) {
        if (maxUpdate.equals(processUpdate)) {
            return true;
        } else {
            return false;
        }
    }


    private boolean canLockSync(Date maxUpdate, Date processUpdate) {
        if (maxUpdate.before(processUpdate)) {
            return true;
        } else {
            Long offset = maxUpdate.getTime() - processUpdate.getTime();
            if (offset <= TransferConst.CAN_LOCK_INTERVAL) {
                log.info("offset:{}小于限定值，可以进入lock状态", offset);
                return true;
            } else {
                return false;
            }
        }
    }

}
