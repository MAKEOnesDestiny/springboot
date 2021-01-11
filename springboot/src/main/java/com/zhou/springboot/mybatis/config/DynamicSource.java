package com.zhou.springboot.mybatis.config;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class DynamicSource extends AbstractRoutingDataSource {

    public static final ThreadLocal<String> holder = new ThreadLocal<>();
    private static DataSourceTransactionManager transactionManager = null;
    private ApplicationContext atx;

    public DynamicSource(ApplicationContext atx) {
        this.atx = atx;
    }

    public static void setDataSource(String target) {
        holder.set(target);
    }

    public static String getDataSouce() {
        return holder.get();
    }

    protected Object determineCurrentLookupKey() {
        return getDataSouce();
    }

    public DynamicSource.Status getStatus() {
        return new DynamicSource.StatusImpl(TransactionAspectSupport.currentTransactionStatus());
    }

    public DynamicSource.Status getStatus(int definition) {
        if (transactionManager == null) {
            transactionManager = atx.getBean(DataSourceTransactionManager.class);
        }

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(definition);
        return new DynamicSource.StatusImpl(transactionManager.getTransaction(def));
    }

    public void execute(DynamicSource.Service service, int definition) {
        DynamicSource.Status status = getStatus(definition);

        try {
            service.execute(status);
            status.commit();
        } catch (Exception var4) {
            status.rollback();
        }

    }

    private static class StatusImpl implements DynamicSource.Status {

        private TransactionStatus status;

        public void execute() {
        }

        public StatusImpl(TransactionStatus status) {
            this.status = status;
        }

        public boolean isNewTransaction() {
            return this.status.isNewTransaction();
        }

        public boolean hasSavepoint() {
            return this.status.hasSavepoint();
        }

        public void setRollbackOnly() {
            this.status.setRollbackOnly();
        }

        public boolean isRollbackOnly() {
            return this.status.isRollbackOnly();
        }

        public void flush() {
            this.status.flush();
        }

        public boolean isCompleted() {
            return this.status.isCompleted();
        }

        public Object createSavepoint() {
            return this.status.createSavepoint();
        }

        public void rollbackToSavepoint(Object o) {
            this.status.rollbackToSavepoint(o);
        }

        public void releaseSavepoint(Object o) {
            this.status.releaseSavepoint(o);
        }

        public void commit() {
            DynamicSource.transactionManager.commit(this.status);
        }

        public void rollback() {
            DynamicSource.transactionManager.rollback(this.status);
        }

        public int getPropagationBehavior() {
            return 0;
        }

        public int getIsolationLevel() {
            return 0;
        }

        public int getTimeout() {
            return 0;
        }

        public boolean isReadOnly() {
            return false;
        }

        public String getName() {
            return null;
        }
    }

    public interface Service {

        void execute(DynamicSource.Status status);
    }

    public interface Status extends TransactionStatus, TransactionDefinition {

        void commit();

        void rollback();
    }

}
