package com.zhou.springboot.test;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.annotation.ExcelProperty;
import java.io.File;
import java.util.List;
import org.junit.Test;

public class EasyExcelTest {

    @Test
    public void doReadTest() {
        List<ExcelTestBean> testBeans =
                EasyExcelFactory.read(new File("/Users/hfzhou/Desktop/test.xlsx")).sheet(0)
                        .head(ExcelTestBean.class)
                        .doReadSync();
        System.out.println();
    }

    public static final class ExcelTestBean {

        @ExcelProperty("字段名")
        private String columnName;
        @ExcelProperty("中文字段名")
        private String chineseColumnName;
        @ExcelProperty("数据类型")
        private String dateType;
        @ExcelProperty("是否主键")
        private String isUniq;
        @ExcelProperty("数据来源")
        private String dataSource;
        @ExcelProperty("业务指标定义")
        private String bizDef;

        public String getColumnName() {
            return columnName;
        }

        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }

        public String getChineseColumnName() {
            return chineseColumnName;
        }

        public void setChineseColumnName(String chineseColumnName) {
            this.chineseColumnName = chineseColumnName;
        }

        public String getDateType() {
            return dateType;
        }

        public void setDateType(String dateType) {
            this.dateType = dateType;
        }

        public String getIsUniq() {
            return isUniq;
        }

        public void setIsUniq(String isUniq) {
            this.isUniq = isUniq;
        }

        public String getDataSource() {
            return dataSource;
        }

        public void setDataSource(String dataSource) {
            this.dataSource = dataSource;
        }

        public String getBizDef() {
            return bizDef;
        }

        public void setBizDef(String bizDef) {
            this.bizDef = bizDef;
        }
    }

}
