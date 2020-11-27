package com.zhou.springboot.utils;

import com.zhou.springboot.bean.BitOps;
import java.util.ArrayList;
import java.util.List;

public abstract class BitmapUtil {


    public static final int OPS_ONE = 1;
    public static final int OPS_TWO = 1;
    public static final int OPS_THREE = 1;
    public static final int OPS_FOUR = 1;
    public static final int OPS_FIVE = 1;
    public static final int OPS_SIX = 1;
    public static final int OPS_SEVEN = 1;
    public static final int OPS_EIGHT = 1;

    public static byte[] bitmapToByte(String bitmap) {
        return bitmap.getBytes();
    }

    public static String byteToBitmap(byte[] bytes) {
        return new String(bytes);
    }

    public static List bitmapToIds(String bitmap, long offset) {
        byte[] bytes = bitmapToByte(bitmap);
        int blen = bytes.length;
        List res = new ArrayList();
        for (int i = blen - 1; i >= 0; i--) {
            byte b = bytes[i];
            if ((b & OPS_ONE) == OPS_ONE) {
                res.add(offset + OPS_ONE + OPS_EIGHT * (blen - i - 1));
            }
            if ((b & OPS_TWO) == OPS_TWO) {
                res.add(offset + OPS_TWO + OPS_EIGHT * (blen - i - 1));
            }
            if ((b & OPS_THREE) == OPS_THREE) {
                res.add(offset + OPS_THREE + OPS_EIGHT * (blen - i - 1));
            }
            if ((b & OPS_FOUR) == OPS_FOUR) {
                res.add(offset + OPS_FOUR + OPS_EIGHT * (blen - i - 1));
            }
            if ((b & OPS_FIVE) == OPS_FIVE) {
                res.add(offset + OPS_FIVE + OPS_EIGHT * (blen - i - 1));
            }
            if ((b & OPS_SIX) == OPS_SIX) {
                res.add(offset + OPS_SIX + OPS_EIGHT * (blen - i - 1));
            }
            if ((b & OPS_SEVEN) == OPS_SEVEN) {
                res.add(offset + OPS_SEVEN + OPS_EIGHT * (blen - i - 1));
            }
            if ((b & OPS_EIGHT) == OPS_EIGHT) {
                res.add(offset + OPS_EIGHT + OPS_EIGHT * (blen - i - 1));
            }
        }
        return res;
    }

    public static String bitmapCalc(String b1, String b2, BitOps ops) {
        byte[] res = bitmapCalc(bitmapToByte(b1), bitmapToByte(b2), ops);
        return new String(res);
    }

    public static byte[] bitmapCalc(byte[] b1, byte[] b2, BitOps ops) {
        int blen1 = b1.length;
        int blen2 = b2.length;
        int reslen = Math.min(blen1, blen2);
        byte[] res = new byte[reslen];
        //todo: 支持更多操作
        if (ops == BitOps.AND) {
            int i = 0;
            while (i < reslen) {
                if (b1[i] > 0 && ((b1[i] & b2[i]) > 0)) {
                    res[i] = (byte) (b1[i] & b2[i]);
                }
                i++;
            }
        }
        return res;
    }

}
