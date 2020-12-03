package com.zhou.springboot.utils;

/**
 * 位图值对象
 */
public class BitmapVo {

    public String ids;

    public Long offset;

    public String bitmap;

    public BitmapVo(String ids, Long offset, String bitmap) {
        this.ids = ids;
        this.offset = offset;
        this.bitmap = bitmap;
    }
}
