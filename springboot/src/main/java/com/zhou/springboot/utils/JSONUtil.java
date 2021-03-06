package com.zhou.springboot.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class JSONUtil {

    public static <T> List<T> findAllObjectRecursive(String key, Map<String, Object> map, Class<T> tClass) {
        if (map == null) throw new IllegalArgumentException("map can't be null");
        if (tClass == null) throw new IllegalArgumentException("tClass can't be null");
        //不支持数组类型的检索
        if (tClass.getName().startsWith("["))
            throw new UnsupportedOperationException(tClass.getName() + " not supported!");
        tClass = adaptPrimitive(tClass);
        List<T> result = new ArrayList<>();
        findAllObjectRecursive0(key, map, tClass,result);
        return result;
    }

    private static <T> void findAllObjectRecursive0(String key, Map<String, Object> map, Class<T> tClass,
                                                    List<T> result) {
        Object obj = map.get(key);
        if (obj != null && tClass.isAssignableFrom(obj.getClass()) && key != null) {
            result.add((T)obj);
        }
        for (Map.Entry e : map.entrySet()) {
            Object eValue = e.getValue();
            if (eValue instanceof Map) {
                findAllObjectRecursive0(key, (Map<String, Object>) eValue, tClass,result);
            }
            if (eValue instanceof List) {
                findAllObjectRecursiveFromList(key, (List) eValue, tClass,result);
            }
        }
    }

    public static <T> T findObjectRecursive(String key, Map<String, Object> map, Class<T> tClass) {
        if (map == null) throw new IllegalArgumentException("map can't be null");
        if (tClass == null) throw new IllegalArgumentException("tClass can't be null");
        //不支持数组类型的检索
        if (tClass.getName().startsWith("["))
            throw new UnsupportedOperationException(tClass.getName() + " not supported!");
        tClass = adaptPrimitive(tClass);
        return findObjectRecursive0(key, map, tClass);
    }

    private static <T> T findObjectRecursive0(String key, Map<String, Object> map, Class<T> tClass) {
        Object obj = map.get(key);
        if (obj != null && tClass.isAssignableFrom(obj.getClass()) && key != null) {
            return (T) obj;
        }
        for (Map.Entry e : map.entrySet()) {
            Object eValue = e.getValue();
            if (eValue instanceof Map) {
                Object result = findObjectRecursive0(key, (Map<String, Object>) eValue, tClass);
                //深度优先遍历
                if (result == null) continue;
                else return (T) result;
            }
            if (eValue instanceof List) {
                Object result = findObjectRecursiveFromList(key, (List) eValue, tClass);
                if (result == null) continue;
                else return (T) result;
            }
        }
        //not found
        return null;
    }

    /**
     * 从List中寻找符合条件的对象(一旦找到一个符合条件的就立刻停止)
     *
     * @param key    可为null,为null则在list中寻找非key-value形式的符合条件的值,否则寻找key-value形式的value
     * @param list   被寻找的list
     * @param tClass 目标类型
     * @param <T>
     * @return
     */
    public static <T> T findObjectRecursiveFromList(String key, List list, Class<T> tClass) {
        if (list == null) throw new IllegalArgumentException("list can't be null");
        if (list.size() == 0) return null;
        for (Object obj : list) {
            if (key == null && tClass.isAssignableFrom(obj.getClass())) {
                return (T) obj;
            }
            if (List.class.isAssignableFrom(obj.getClass())) {
                return findObjectRecursiveFromList(key, (List) obj, tClass);
            }
            if (Map.class.isAssignableFrom(obj.getClass())) {
                return findObjectRecursive(key, (Map<String, Object>) obj, tClass);
            }
        }
        return null;
    }

    public static <T> void findAllObjectRecursiveFromList(String key, List list, Class<T> tClass,List<T> result) {
        if (list == null) throw new IllegalArgumentException("list can't be null");
        if (list.size() == 0) return ;
        for (Object obj : list) {
            if (key == null && tClass.isAssignableFrom(obj.getClass())) {
                result.add((T)obj);
            }
            if (List.class.isAssignableFrom(obj.getClass())) {
                findAllObjectRecursiveFromList(key, (List) obj, tClass,result);
            }
            if (Map.class.isAssignableFrom(obj.getClass())) {
                findAllObjectRecursive0(key, (Map<String, Object>) obj, tClass,result);
            }
        }
    }

    private static <T> Class<T> adaptPrimitive(Class<T> clazz) {
        if (clazz.isPrimitive()) {
            switch (clazz.getName()) {
                case "byte":
                    clazz = (Class<T>) Byte.class;
                    break;
                case "short":
                    clazz = (Class<T>) Short.class;
                    break;
                case "int":
                    clazz = (Class<T>) Integer.class;
                    break;
                case "long":
                    clazz = (Class<T>) Long.class;
                    break;
                case "float":
                    clazz = (Class<T>) Float.class;
                    break;
                case "double":
                    clazz = (Class<T>) Double.class;
                    break;
                case "boolean":
                    clazz = (Class<T>) Boolean.class;
                    break;
                case "char":
                    clazz = (Class<T>) Character.class;
                    break;
            }
        }
        return clazz;
    }


}
