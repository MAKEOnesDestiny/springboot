package com.zhou.springboot.easytrans;

public interface TransferConst {

    int INIT = 0;
    int SYNC = 1;
    int LOCK_SYNC = 2;
    int OLD_OFF = 3;
    int FINISH = 4;

    int TRANSFER_BATCH = 10000;

    //60s
    long CAN_LOCK_INTERVAL = 60 * 1000;

}
