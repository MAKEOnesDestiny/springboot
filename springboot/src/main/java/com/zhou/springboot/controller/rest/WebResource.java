package com.zhou.springboot.controller.rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;

public class WebResource {

    //url路径，不包含context
    private String urlPath;
    //GET POST DELETE PUT ...
    private String restType;
    private String consumeType;
    private String produceType;
    private String apiDoc;
    private String menuDoc;

    //null if no need
    private String jsonExample;
    private List<InputParam> inputParams;

    private String returnExample;

    public WebResource(String urlPath, String restType, String consumeType,
                       String produceType, String apiDoc, String menuDoc,
                       List<InputParam> inputParams) {
        this(urlPath, restType, consumeType, produceType, apiDoc, menuDoc, inputParams, null);
    }

    public WebResource(String urlPath, String restType, String consumeType,
                       String produceType, String apiDoc, String menuDoc,
                       List<InputParam> inputParams, String jsonExample) {
        this.urlPath = urlPath;
        this.restType = restType;
        this.consumeType = consumeType;
        this.produceType = produceType;
        this.apiDoc = apiDoc;
        this.menuDoc = menuDoc;
        this.inputParams = inputParams;
        this.jsonExample = jsonExample;
    }

    private WebResource() {
    }

    public String getShowType() {
        if (MediaType.APPLICATION_JSON_UTF8_VALUE.equals(consumeType)) {
            return ResourceConst.PARAM_JSON;
        }
        if (MediaType.APPLICATION_FORM_URLENCODED_VALUE.equals(consumeType)
                || MediaType.MULTIPART_FORM_DATA_VALUE.equals(consumeType)) {
            return ResourceConst.PARAM_FORM;
        }
        return null;
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

    public String getConsumeType() {
        return consumeType;
    }

    public void setConsumeType(String consumeType) {
        this.consumeType = consumeType;
    }

    public String getProduceType() {
        return produceType;
    }

    public void setProduceType(String produceType) {
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

    public String getJsonExample() {
        return jsonExample;
    }

    public void setJsonExample(String jsonExample) {
        this.jsonExample = jsonExample;
    }

    @Override
    public String toString() {
        return "WebResource{" +
                "urlPath='" + urlPath + '\'' +
                ", restType='" + restType + '\'' +
                ", consumeType='" + consumeType + '\'' +
                ", produceType='" + produceType + '\'' +
                ", apiDoc='" + apiDoc + '\'' +
                ", menuDoc='" + menuDoc + '\'' +
                ", jsonExample='" + jsonExample + '\'' +
                ", inputParams=" + inputParams +
                '}';
    }

    public static final class WebResourceBuilder {

        private final WebResource webResource;

        public WebResourceBuilder(String urlPath, String restType, String consumeType,
                                  String produceType, String apiDoc, String menuDoc) {
            this.webResource = new WebResource();
            this.webResource.urlPath = urlPath;
            this.webResource.restType = restType;
            this.webResource.consumeType = consumeType;
            this.webResource.produceType = produceType;
            this.webResource.apiDoc = apiDoc;
            this.webResource.menuDoc = menuDoc;
        }

        public WebResourceBuilder addInputParam(InputParam inputParam) {
            if (this.webResource.inputParams == null) {
                this.webResource.inputParams = new ArrayList<>();
            }
            this.webResource.inputParams.add(inputParam);
            return this;
        }

        public WebResourceBuilder setJsonExample(String jsonExample) {
            this.webResource.jsonExample = jsonExample;
            return this;
        }

        public WebResource build() {
            return this.webResource;
        }

        WebResource errorBuild(){
            webResource.inputParams = null;
            return this.webResource;
        }

    }

}
