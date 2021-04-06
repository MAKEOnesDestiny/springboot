package com.zhou.springboot.controller.rest;

import java.util.List;
import org.apache.http.entity.ContentType;

public class WebResource {

    //url路径，不包含context
    private String urlPath;
    //GET POST DELETE PUT ...
    private String restType;
    private ContentType consumeType;
    private ContentType produceType;
    private String apiDoc;
    private String menuDoc;

    private List<InputParam> inputParams;

    public WebResource(String urlPath, String restType, ContentType consumeType,
                       ContentType produceType, String apiDoc, String menuDoc,
                       List<InputParam> inputParams) {
        this.urlPath = urlPath;
        this.restType = restType;
        this.consumeType = consumeType;
        this.produceType = produceType;
        this.apiDoc = apiDoc;
        this.menuDoc = menuDoc;
        this.inputParams = inputParams;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getRestType() {
        return restType;
    }

    public void setRestType(String restType) {
        this.restType = restType;
    }

    public ContentType getConsumeType() {
        return consumeType;
    }

    public void setConsumeType(ContentType consumeType) {
        this.consumeType = consumeType;
    }

    public ContentType getProduceType() {
        return produceType;
    }

    public void setProduceType(ContentType produceType) {
        this.produceType = produceType;
    }

    public String getApiDoc() {
        return apiDoc;
    }

    public void setApiDoc(String apiDoc) {
        this.apiDoc = apiDoc;
    }

    public String getMenuDoc() {
        return menuDoc;
    }

    public void setMenuDoc(String menuDoc) {
        this.menuDoc = menuDoc;
    }

    public List<InputParam> getInputParams() {
        return inputParams;
    }

    public void setInputParams(List<InputParam> inputParams) {
        this.inputParams = inputParams;
    }

    @Override
    public String toString() {
        return "WebResource{" +
                "urlPath='" + urlPath + '\'' +
                ", restType='" + restType + '\'' +
                ", consumeType=" + consumeType +
                ", produceType=" + produceType +
                ", apiDoc='" + apiDoc + '\'' +
                ", menuDoc='" + menuDoc + '\'' +
                ", inputParams=" + inputParams +
                '}';
    }
}
