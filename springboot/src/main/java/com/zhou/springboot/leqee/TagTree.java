package com.zhou.springboot.leqee;

public class TagTree {

    private String tagCode;//标签编码,注意树叶不会有编码，但是在最终导出文件中不应该出现,
    private String tagName;//标签名称
    private Integer leaf; //1代表树叶
    private TagTree parent;
    private String[] keyword;

    //todo: 新增匹配表达式？

    public TagTree(String tagCode, String tagName, Integer leaf, TagTree parent, String... keyword) {
        this.tagCode = tagCode;
        this.tagName = tagName;
        this.leaf = leaf;
        this.parent = parent;
        this.keyword = keyword;
    }

    public String matchKeyword(String sentence) {
        if (sentence == null) {
            return null;
        }
        if (keyword == null) {
            return null;
        }
        for (int i = 0; i < keyword.length; i++) {
            String k = keyword[i];
            if (sentence.contains(k)) {
                return k;
            }
        }
        return null;
    }

    public String getTagCode() {
        return tagCode;
    }

    public void setTagCode(String tagCode) {
        this.tagCode = tagCode;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }

    public TagTree getParent() {
        return parent;
    }

    public void setParent(TagTree parent) {
        this.parent = parent;
    }

    public String[] getKeyword() {
        return keyword;
    }

    public void setKeyword(String[] keyword) {
        this.keyword = keyword;
    }
}
