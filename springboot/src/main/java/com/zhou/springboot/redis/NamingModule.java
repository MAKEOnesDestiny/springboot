package com.zhou.springboot.redis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class NamingModule {


    //订单创建时间 + condition_id + offset
    public static final String SEPARATE = ":"; //key中的分割符

    public static final SimpleDateFormat TIME_PREFIX_FORMAT = new SimpleDateFormat("yyyyMMddHHmm");

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final String CONDITION_CONFIG_PREFIX = "config:condition:";

    public static final String CONDITION_TYPE = "type";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取模糊匹配的key
     *
     * @param key
     * @param id
     */
    public String assemblePatternKey(String key, Long id) {
        return key + SEPARATE + id + SEPARATE + "*";
    }

    public String assembleKeyByBitmap(String key, Long id, Long offset) {
        return key + SEPARATE + id + SEPARATE + offset;
    }

    public Long getOffsetByKey(String key) {
        if (StringUtils.isBlank(key)) {
            throw new IllegalArgumentException("key不能为空,key=" + key);
        }
        String[] ss = key.split(SEPARATE);
        if (ss.length != 3) {
            throw new IllegalArgumentException("非法的key,key=" + key);
        }
        return Long.valueOf(ss[2]);
    }


    private List<String> getTimeRegion(Date beginDate, Date endDate) throws ParseException {
        List<String> res = new ArrayList<>();
        //将秒和分置为0
        SimpleDateFormat hourSdf = new SimpleDateFormat("yyyyMMddHH0000");
        beginDate = TIME_PREFIX_FORMAT.parse(hourSdf.format(beginDate));
        do {
            res.add(hourSdf.format(beginDate));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(beginDate);
            calendar.add(Calendar.HOUR, 1); //加1小时
            beginDate = calendar.getTime();
        } while (beginDate.before(endDate));
        return res;
    }

}
