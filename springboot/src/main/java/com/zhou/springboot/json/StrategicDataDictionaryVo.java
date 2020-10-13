package com.zhou.springboot.json;

public class StrategicDataDictionaryVo {

    private String tableName;

    private String tableNameInChinese;

    private String columnName;

    private String columnNameInChinese;

    private String dataSource;

    private String businessIndicatorDef;

    private String modifyType;

    private String dbName;

    public StrategicDataDictionaryVo() {
    }

    ;

    public StrategicDataDictionaryVo(String tableName, String columnName ,String dbName) {
        this.tableName = tableName;
        this.columnName = columnName;
        this.dbName = dbName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableNameInChinese() {
        return tableNameInChinese;
    }

    public void setTableNameInChinese(String tableNameInChinese) {
        this.tableNameInChinese = tableNameInChinese;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnNameInChinese() {
        return columnNameInChinese;
    }

    public void setColumnNameInChinese(String columnNameInChinese) {
        this.columnNameInChinese = columnNameInChinese;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getBusinessIndicatorDef() {
        return businessIndicatorDef;
    }

    public void setBusinessIndicatorDef(String businessIndicatorDef) {
        this.businessIndicatorDef = businessIndicatorDef;
    }

    public String getModifyType() {
        return modifyType;
    }

    public void setModifyType(String modifyType) {
        this.modifyType = modifyType;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StrategicDataDictionaryVo) {
            if (((StrategicDataDictionaryVo) obj).tableName == null || ((StrategicDataDictionaryVo) obj).columnName == null || ((StrategicDataDictionaryVo) obj).dbName == null) {
                return false;
            } else {
                return ((StrategicDataDictionaryVo) obj).tableName.equals(this.tableName) && ((StrategicDataDictionaryVo) obj).columnName.equals(this.columnName) && ((StrategicDataDictionaryVo) obj).dbName.equals(this.dbName);
            }
        }

        return false;
    }

}
