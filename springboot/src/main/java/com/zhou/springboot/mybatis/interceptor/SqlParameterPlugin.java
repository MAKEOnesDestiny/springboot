package com.zhou.springboot.mybatis.interceptor;

import java.sql.PreparedStatement;
import java.util.Properties;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

@Intercepts(@Signature(type = ParameterHandler.class, method = "setParameters", args = {PreparedStatement.class}))
public class SqlParameterPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        ParameterHandler parameterHandler = (ParameterHandler) args[0];
        Object parameterObject = parameterHandler.getParameterObject();
//        MetaObject metaObject = configuration.newMetaObject(parameterObject);
        return null;
    }

    @Override
    public Object plugin(Object target) {
        //形成一条链
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
