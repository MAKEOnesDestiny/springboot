package com.zhou.springboot.easytrans;

import com.zhou.springboot.dao.TestMapper;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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

        job.startTransfer();
        while (!canLockSync(maxUpdateSnapShot, lastUpdate)) {
            testMapper.transferData(oldTable, newTable, lastUpdate, TransferConst.TRANSFER_BATCH);
            lastUpdate = testMapper.getMaxDate(newTable);
        }
        job.lockTable();

        testMapper.lockTable(oldTable);
        //锁了表之后需要在特定的时间里切换成功，不然需要超时重试
        Date maxUpdate = testMapper.getMaxDate(oldTable);
        while (!transferFinsh(maxUpdate, lastUpdate)) {
            testMapper.transferData(oldTable, newTable, lastUpdate, TransferConst.TRANSFER_BATCH);
            lastUpdate = testMapper.getMaxDate(newTable);
        }

        String tempTable = oldTable + "$$_temp";
        //        testMapper.unlockTableAndRename(oldTable, tempTable);
        testMapper.unlockTable(oldTable);
        job.unlockTable();

        testMapper.renameTable(oldTable, tempTable);
        testMapper.renameTable(newTable, oldTable);

        job.finish();
    }

    public void doTransfer() {

    }

    private Date defaultDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970, 1, 1, 0, 0, 0);
        return calendar.getTime();
    }

    private boolean transferFinsh(Date maxUpdate, Date processUpdate) {
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
