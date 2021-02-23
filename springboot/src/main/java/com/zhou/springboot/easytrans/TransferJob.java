package com.zhou.springboot.easytrans;

import static com.zhou.springboot.easytrans.TransferConst.INIT;

import com.zhou.springboot.utils.IDUtil;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransferJob {

    private static final Logger log = LoggerFactory.getLogger(TransferJob.class);

    private final Long jobId;
    private String tableName;
    //上次迁移成功时间戳，如果上次没有迁移过则为null
    private Date lastTransferedDate;
    //新表和旧表的差值
    private Long offset;

    private volatile int phase = INIT;
    private volatile int result;

    public TransferJob(String tableName, Date lastTransferedDate) {
        this.jobId = new IDUtil().getId();
        this.tableName = tableName;
        this.lastTransferedDate = lastTransferedDate;
    }

    public void startTransfer() {
        if (phase != TransferConst.INIT && phase != TransferConst.SYNC && phase != TransferConst.LOCK_SYNC) {
            throw new IllegalStateException("开始传送数据时，错误的任务状态:" + phase);
        }
        phase = TransferConst.SYNC;
        log.debug("{}==>任务设置为SYNC", jobId);
    }

    public void lockTable() {
        if (phase != TransferConst.SYNC) {
            throw new IllegalStateException("开始传送数据时，错误的任务状态:" + phase);
        }
        phase = TransferConst.LOCK_SYNC;
        log.debug("{}==>任务设置为LOCK_SYNC", jobId);
    }

    public void unlockTable() {
        if (phase != TransferConst.LOCK_SYNC) {
            throw new IllegalStateException("开始传送数据时，错误的任务状态:" + phase);
        }
        phase = TransferConst.OLD_OFF;
        log.debug("{}==>任务设置为OLD_OFF", jobId);
    }

    public void finish() {
        if (phase != TransferConst.OLD_OFF) {
            throw new IllegalStateException("开始传送数据时，错误的任务状态:" + phase);
        }
        phase = TransferConst.FINISH;
        log.debug("{}==>任务设置为FINISH", jobId);
    }

    public Long getJobId() {
        return jobId;
    }

    @Override
    public String toString() {
        return "TransferJob{" +
                "jobId=" + jobId +
                ", tableName='" + tableName + '\'' +
                ", lastTransferedDate=" + lastTransferedDate +
                ", offset=" + offset +
                ", phase=" + phase +
                ", result=" + result +
                '}';
    }
}
