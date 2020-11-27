package com.zhou.springboot.utils;

public class IDUtil {

    private final long workerId = 0L; //
    private static final long twepoch = 1473383349999L; //2016-09-09 09:09:09
    private long sequence = 0L;
    private static final long workerIdBits = 10L;
    public static final long maxWorkerId = 1023L;
    private static final long sequenceBits = 10L;
    private static final long workerIdShift = 10L;
    private static final long timestampLeftShift = 20L;
    public static final long sequenceMask = 1023L;
    private long lastTimestamp = -1L;

    public long getId() {
        long timestamp = timeGen();
        if (this.lastTimestamp == timestamp) {
            this.sequence = this.sequence + 1L & 1023L;
            if (this.sequence == 0L) {
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = 0L;
        }

        if (timestamp < this.lastTimestamp) {
            try {
                throw new Exception(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                                                  this.lastTimestamp - timestamp));
            } catch (Exception var5) {
                var5.printStackTrace();
            }
        }

        this.lastTimestamp = timestamp;
        //2^44=17592186044416(14)
        //时间戳 + workerId(10bit) + sequence(10bit)
        long nextId = timestamp - 1473383349999L << 20 | this.workerId << 10 | this.sequence;
        return nextId;
    }

    private static long timeGen() {
        return System.currentTimeMillis();
    }

    private long tilNextMillis(final long lastTimestamp) {
        long timestamp;
        for (timestamp = this.timeGen(); timestamp <= lastTimestamp; timestamp = this.timeGen()) {
            ;
        }

        return timestamp;
    }

    //139185626622722048-1473383349999
    public static void main(String[] args) {
        System.out.println(139185626622722048L-1473383349999L);
        System.out.println(new IDUtil().getId());
    }

}
