package com.zhou.springboot.easyexcel.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

public class DateTypeConverter implements Converter<String> {

    @Override
    public Class supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public String convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
                                    GlobalConfiguration globalConfiguration) throws Exception {
        return null;
    }

    @Override
    public CellData convertToExcelData(String value, ExcelContentProperty contentProperty,
                                       GlobalConfiguration globalConfiguration) throws Exception {
        String valueInChinese = null;
        switch (value) {
            case "QB":
                valueInChinese = "衍生指标";
                break;
            case "YS":
                valueInChinese = "衍生指标";
                break;
            case "DB":
                valueInChinese = "数据库指标";
                break;
            case "EB_YS":
                valueInChinese = "衍生指标";
                break;
            case "EB_DB":
                valueInChinese = "数据库指标";
                break;
            default:
                throw new RuntimeException("Unknow Type:" + value);
        }
        return new CellData(valueInChinese);
    }


}
