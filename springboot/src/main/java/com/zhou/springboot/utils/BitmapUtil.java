package com.zhou.springboot.utils;

import com.zhou.springboot.bean.BitOps;
import java.util.ArrayList;
import java.util.List;

public abstract class BitmapUtil {


    public static final byte OPS_ONE = 0x01;
    public static final byte OPS_TWO = 0x02;
    public static final byte OPS_THREE = 0x04;
    public static final byte OPS_FOUR = 0x08;
    public static final byte OPS_FIVE = 0x10;
    public static final byte OPS_SIX = 0x20;
    public static final byte OPS_SEVEN = 0x40;
    public static final short OPS_EIGHT = 0x80; //avoid negative


    public static byte[] bitmapToByte(String bitmap) {
        int len = bitmap.length();
        byte[] res = new byte[len * 2];
        char c;
        for (int i = 0; i < bitmap.length(); i++) {
            c = bitmap.charAt(i);
            res[2 * i + 1] = (byte) (c & 0xff);
            res[2 * i] = (byte) ((c >> 8) & 0xff);
        }
        return res;
    }

    public static String byteToBitmap(byte[] bytes) {
        return new String(bytes);
    }

    /**
     * 将用,分割的字符串转换成bitmap的字符串表示形式
     *
     * @param s
     */
   /* public static String stringToBitmap(String s) {
        String[] ss = s.split(",");
        Long offset = Long.valueOf(ss[0]); //offset代表第一个订单编号
        Long max = Long.valueOf(ss[ss.length - 1]);
        int length = (int) ((max - offset) / 8 + (((max - offset) % 8) == 0 ? 0 : 1));
        byte[] bitmap = new byte[length];
        for (String single : ss) {
            Long value = Long.valueOf(single);
            int pos = (int) (value - offset);
            setBit(bitmap, pos);
        }
        try {
            return new String(bitmap, "utf-8");
        } catch (UnsupportedEncodingException e) {
        }
        //impossible
        return null;
    }*/

    /**
     * 将用,分割的字符串转换成bitmap的字符串表示形式
     *
     * @param s
     */
    public static BitmapVo stringToBitmap(String s) {
        String[] ss = s.split(",");
        Long offset = Long.valueOf(ss[0]); //offset代表第一个订单编号
        Long max = Long.valueOf(ss[ss.length - 1]);
        int length = (int) ((max - offset) / 8 + (((max - offset) % 8) == 0 ? 0 : 1));
        byte[] bitmap = new byte[length];
        for (String single : ss) {
            Long value = Long.valueOf(single);
            int pos = (int) (value - offset);
            setBit(bitmap, pos);
        }

        return new BitmapVo(s, offset, new String(assemble(bitmap)));
    }

    private static char[] assemble(byte[] bytes) {
        int len = bytes.length / 2 + bytes.length % 2;
        char[] chars = new char[len];
        int pos = 0;
        for (int i = 0; i < len; i++) {
            char high = (char) (bytes[pos++] << 8);
            char low;
            if (pos >= bytes.length) {
                low = 0x0000;
            } else {
                low = (char) bytes[pos++];
            }
            char c = (char) (high | low);
            chars[i] = c;
        }
        return chars;
    }

    public static String bitmapCalc(String b1, String b2, BitOps ops) {
        byte[] res = bitmapCalc(bitmapToByte(b1), bitmapToByte(b2), ops);
        return new String(res);
    }

    public static void main(String[] args) {

        String ids = "193310865,193310888,193310889,193310890,193310986,193311102,193311114,193311172,193311199,193311200,193311275,193311276,193311277,193311317,193311337,193311356,193311359,193311358,193311360,193311460,193311473,193311617,193311711,193311713,193311745,193311822,193311861,193311866,193311915,193311977,193312053,193312074,193312129,193312183,193312184,193312234,193312235,193312296,193312297,193312350,193312376,193312377,193312378,193312430,193312457,193312480,193312481,193312482,193312542,193312543,193312591,193312592,193312779,193312814,193312816,193312819,193312862,193312870,193312872,193312922,193312948,193312949,193312952,193312985,193313025,193313055,193313178,193313343,193313345,193313346,193313347,193313368,193313377,193313387,193313388,193313428,193313458,193313460,193313544,193313564,193313620,193313621,193313627,193313771,193313772,193313784,193313852,193313853,193313943,193313968,193313986,193314021,193314063,193314086,193314085,193314110,193314111,193314158,193314224,193314225,193314250,193314317,193314318,193314367,193314383,193314393,193314394,193314406,193314424,193314442,193314476,193314508,193314510,193314514,193314540,193314569,193314645,193314647,193314670,193314666,193314668,193314672,193314710,193314711,193314712,193314739,193314791,193314815,193314816,193314849,193314854,193314875,193314931,193314999,193315000,193315001,193315051,193315070,193315100,193315157,193315162,193315308,193315307,193315348,193315365,193315438,193315437,193315496,193315497,193315570,193315605,193315606,193315689,193315750,193315751,193315849,193315870,193315923,193316014,193316032,193316035,193316050,193316115,193316116,193316117,193316145,193316147,193316194,193316221,193316257,193316260,193316307,193316310,193316305,193316329,193316358,193316420,193316437,193316448,193316447";

        BitmapVo bitmap = stringToBitmap(ids);
        byte[] bytes = bitmapToByte(bitmap.bitmap);
        List list = bitmapToIds(bitmap.bitmap, 193310865L);
        System.out.println();
    }


    public static List bitmapToIds(String bitmap, long offset) {
        byte[] bytes = bitmapToByte(bitmap);
        int blen = bytes.length;
        List res = new ArrayList();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            if ((b & OPS_ONE) == OPS_ONE) {
                res.add(offset + 0 + 8 * i);
            }
            if ((b & OPS_TWO) == OPS_TWO) {
                res.add(offset + 1 + 8 * i);
            }
            if ((b & OPS_THREE) == OPS_THREE) {
                res.add(offset + 2 + 8 * i);
            }
            if ((b & OPS_FOUR) == OPS_FOUR) {
                res.add(offset + 3 + 8 * i);
            }
            if ((b & OPS_FIVE) == OPS_FIVE) {
                res.add(offset + 4 + 8 * i);
            }
            if ((b & OPS_SIX) == OPS_SIX) {
                res.add(offset + 5 + 8 * i);
            }
            if ((b & OPS_SEVEN) == OPS_SEVEN) {
                res.add(offset + 6 + 8 * i);
            }
            if ((b & OPS_EIGHT) == OPS_EIGHT) {
                res.add(offset + 7 + 8 * i);
            }
        }
        return res;
    }

    public static void setBit(byte[] bytes, int pos) {
        int segment = pos / 8;
        byte bitOffset = (byte) (pos % 8);
        bytes[segment] = (byte) (bytes[segment] | (1 << bitOffset));
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
