package com.zhou.springboot.mybatis.interceptor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.parsing.GenericTokenParser;
import org.apache.ibatis.parsing.TokenHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * @see com.zhou.springboot.mybatis.config.MybatisConfig
 */
//注意这里的args不能修改成别的
@Intercepts({
                    @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class,
                            RowBounds.class, ResultHandler.class}),
                    @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
            })
public class CustomMybatisPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Map paramMap = (Map) args[1];

        Configuration configuration = ms.getConfiguration();
        MetaObject metaObject = configuration.newMetaObject(paramMap); //用于迭代获取bean中的子元素

        List<Object> paramList = new ArrayList<>();
        BoundSql boundSql = ms.getBoundSql(paramMap);
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        for (int i = 0; i < parameterMappings.size(); i++) {
            ParameterMapping parameterMapping = parameterMappings.get(i);
            String propertyName = parameterMapping.getProperty();

            Object value;
            if (boundSql.hasAdditionalParameter(propertyName)) {
                value = boundSql.getAdditionalParameter(propertyName);
            } else {
                value = metaObject.getValue(propertyName);
            }
            paramList.add(value);
        }

        ParamReplaceHandler paramReplaceHandler = new ParamReplaceHandler(paramList);
        GenericTokenParser parser = new GenericTokenParser("?", "", paramReplaceHandler);
        String parsedSql = parser.parse(ms.getBoundSql(paramMap).getSql());
        parsedSql = parsedSql.replaceAll("\n+\t*\\s*\n+", "\n");
        System.out.println(parsedSql);

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this); //组成一条Executor的代理链
    }

    @Override
    public void setProperties(Properties properties) {
        //nop
    }


    @SuppressWarnings("all")
    public static final class ParamReplaceHandler implements TokenHandler {

        private static final String date_format = "yyyy-MM-dd HH:mm:ss";

        private int index = 0;
        private List<Object> paramList;

        public ParamReplaceHandler(List<Object> paramList) {
            this.paramList = paramList;
        }

        @Override
        public String handleToken(String content) {
            //index每次都会自增
            Object value = paramList.get(index++);
            String res;
            if (value == null) {
                res = "null";
            } else if (value instanceof Integer) {
                res = value.toString();
            } else if (value instanceof Date) {
                SimpleDateFormat sdf = new SimpleDateFormat(date_format);
                res = "'" + sdf.format(value) + "'";
            } else {
                res = "'" + value.toString() + "'";
            }
            return res;
        }

    }


    //todo: byte number float double boolean char
    //todo : print wrong sql if sql contains '?'
    @Deprecated
    @SuppressWarnings("all")
    public static final class MyTokenHandler implements TokenHandler {

        private static final String date_format = "yyyy--MM-dd HH:mm:ss";

        private Map paramMap;
        private int index;

        public MyTokenHandler(Map paramMap) {
            this.paramMap = paramMap;
            this.index = 0;
        }

        @Override
        public String handleToken(String content) {
            index++;
            Object value;
            if (paramMap.containsKey("param" + index)) {
                value = paramMap.get("param" + index);
            } else {
                value = null;
            }

            String res;
            if (value == null) {
                res = "null";
            } else if (value instanceof Integer) {
                res = value.toString();
            } else if (value instanceof Date) {
                SimpleDateFormat sdf = new SimpleDateFormat(date_format);
                res = "'" + sdf.format(value) + "'";
            } else {
                res = "'" + value.toString() + "'";
            }
            return res;
        }
    }

}
