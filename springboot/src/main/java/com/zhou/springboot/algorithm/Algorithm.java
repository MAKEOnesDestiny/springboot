package com.zhou.springboot.algorithm;

import com.zhou.springboot.utils.Profile;
import com.zhou.springboot.utils.TimeProfile;

public class Algorithm {

    public static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : n + 1;
    }

    public static final int tableSizeFor2(int c) throws Exception {
        if ((c & (c - 1)) == 0) return c;
        int p = getMaxDivided(c);
        int mask = (int) Math.pow(2, p) - 1;
        int cover = mask | c;
        return ++cover;
    }

    /**
     * Get the max times of the power of Two which not exceeds {@code c}.
     *
     * @param c
     * @return
     * @throws Exception
     */
    public static int getMaxDivided(int c) throws Exception {
        if (c <= 0)
            throw new Exception("The parameter of getMaxDivided(int) can't be " + c + ".Must be positive.");
        int p = 0;
        for (; ; ) {
            if ((c / 2) < 1)
                return p;
            c /= 2;
            p++;
        }
    }

    public static void main(String[] args) throws Exception {
        Profile profile = new TimeProfile();
        profile.begin();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 100; j++) {
                /* Test Result:
                 *  tableSizeFor() costs 13392ms
                 *  tableSizeFor2() costs 9809ms
                 */
                System.out.println(tableSizeFor2(10000));
            }
        }
        System.out.println("耗时为:" + profile.end() + "ms");
    }

    public static class Test {
        public static void main(String[] args) {
            try {
                System.out.println(tableSizeFor(0));
                System.out.println(tableSizeFor2(0));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
