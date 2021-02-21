package com.zhou.springboot.easytrans;

import static com.zhou.springboot.easytrans.TransferConst.INIT;

import java.util.Date;

public class TransferJob {

    private String tableName;
    //上次迁移成功时间戳，如果上次没有迁移过则为null
    private Date lastTransferedDate;
    //新表和旧表的差值
    private Long offset;

    private volatile int phase = INIT;
    private volatile int result;

    public TransferJob(String tableName, Date lastTransferedDate) {
        this.tableName = tableName;
        this.lastTransferedDate = lastTransferedDate;
    }

    public void startTransfer() {
        if (phase != TransferConst.INIT && phase != TransferConst.SYNC && phase != TransferConst.LOCK_SYNC) {
            throw new IllegalStateException("开始传送数据时，错误的任务状态:" + phase);
        }
        phase = TransferConst.SYNC;
    }

    public void lockTable() {
        if (phase != TransferConst.SYNC) {
            throw new IllegalStateException("开始传送数据时，错误的任务状态:" + phase);
        }
        phase = TransferConst.LOCK_SYNC;
    }

    public void unlockTable() {
        if (phase != TransferConst.LOCK_SYNC) {
            throw new IllegalStateException("开始传送数据时，错误的任务状态:" + phase);
        }
        phase = TransferConst.OLD_OFF;
    }

    public void finish() {
        if (phase != TransferConst.OLD_OFF) {
            throw new IllegalStateException("开始传送数据时，错误的任务状态:" + phase);
        }
        phase = TransferConst.FINISH;
    }

}
