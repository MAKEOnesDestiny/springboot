package com.zhou.springboot.utils;

import java.lang.reflect.Field;
import javax.persistence.Column;

public class SqlUtil {

    public static String getSelectColumnsByClass(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        for (Field f : fields) {
            Column c = f.getAnnotation(Column.class);
            sb.append(c.name()).append(" as ").append(f.getName()).append(",");
        }
        sb.deleteCharAt(sb.length());
        return sb.toString();
    }

}
