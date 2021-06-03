package com.zhou.springboot.leqee;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;

@SuppressWarnings("all")
@ExcelIgnoreUnannotated
public class MatchResult {

    @ExcelProperty(value = "sententce", index = 7)
    private String sentence;
    @ExcelProperty(value = "关键词", index = 15)
    private String keyword; //may be null
    private TagTree leafTree; //may be null
    @ExcelProperty(value = "路径", index = 16)
    private String path; //may be null

    @ExcelProperty(value = "大标签", index = 11)
    private String topTag;
    @ExcelProperty(value = "大标签名称", index = 13)
    private String topTagName;
    @ExcelProperty(value = "小标签", index = 12)
    private String detailTag;
    @ExcelProperty(value = "小标签名称", index = 14)
    private String detailTagName;
    @ExcelProperty(value = "多", index = 10)
    private Integer multi; //1代表多

//    @ExcelProperty(value = "cate_code", index = 1)
    private String cateCode;
//    @ExcelProperty(value = "grouping", index = 2)
    private String grouping;
//    @ExcelProperty(value = "logid", index = 3)
    private String logid;
//    @ExcelProperty(value = "content", index = 4)
    private String content;
//    @ExcelProperty(value = "sid", index = 5)
    private String sid;
//    @ExcelProperty(value = "chat_person", index = 7)
    private String chatPerson;


    @ExcelProperty(value = "flagStatus", index = 1)
    private String flagStatus;
    @ExcelProperty(value = "cate_code", index = 2)
    private String cateCode1;
    @ExcelProperty(value = "_id", index = 3)
    private String _id;
    @ExcelProperty(value = "shopid", index = 4)
    private String shopId;
    @ExcelProperty(value = "chatperson", index = 5)
    private String chatperson;
    @ExcelProperty(value = "chatrecord", index = 6)
    private String chatrecord;
    @ExcelProperty(value = "itemid_0", index = 8)
    private String itemid_0;
    @ExcelProperty(value = "chattime", index = 9)
    private String chattime;




    public MatchResult(String sentence, String keyword, TagTree leafTree) {
        this.sentence = sentence;
        this.keyword = keyword;
        this.leafTree = leafTree;
    }

    public String getFlagStatus() {
        return flagStatus;
    }

    public void setFlagStatus(String flagStatus) {
        this.flagStatus = flagStatus;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public TagTree getLeafTree() {
        return leafTree;
    }

    public void setLeafTree(TagTree leafTree) {
        this.leafTree = leafTree;
    }

    public Integer getMulti() {
        return multi;
    }

    public void setMulti(Integer multi) {
        this.multi = multi;
    }

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }

    public String getLogid() {
        return logid;
    }

    public void setLogid(String logid) {
        this.logid = logid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChatPerson() {
        return chatPerson;
    }

    public void setChatPerson(String chatPerson) {
        this.chatPerson = chatPerson;
    }

    public String getCateCode1() {
        return cateCode1;
    }

    public void setCateCode1(String cateCode1) {
        this.cateCode1 = cateCode1;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getChatperson() {
        return chatperson;
    }

    public void setChatperson(String chatperson) {
        this.chatperson = chatperson;
    }

    public String getChatrecord() {
        return chatrecord;
    }

    public void setChatrecord(String chatrecord) {
        this.chatrecord = chatrecord;
    }

    public String getItemid_0() {
        return itemid_0;
    }

    public void setItemid_0(String itemid_0) {
        this.itemid_0 = itemid_0;
    }

    public String getChattime() {
        return chattime;
    }

    public void setChattime(String chattime) {
        this.chattime = chattime;
    }

    /*************/

    public String getTopTag() {
        if (this.leafTree != null) {
            TagTree tt = this.leafTree;
            while (tt.getParent() != null) {
                tt = tt.getParent();
            }
            return tt.getTagCode();
        }
        return null;
    }

    public String getTopTagName() {
        if (this.leafTree != null) {
            TagTree tt = this.leafTree;
            while (tt.getParent() != null) {
                tt = tt.getParent();
            }
            return tt.getTagName();
        }
        return null;
    }

    public String getDetailTag() {
        if (this.leafTree != null) {
            while (this.leafTree.getParent() != null && this.leafTree.getLeaf() == 1) {
                this.leafTree = this.leafTree.getParent();
            }
            String tag = leafTree.getParent() != null ? leafTree.getParent().getTagCode() : null;
            if (tag != null) {
                tag = tag.substring(tag.indexOf('.') + 1);
            }
            return tag;
        } else {
            return null;
        }
    }

    public String getDetailTagName() {
        if (this.leafTree != null) {
            return leafTree.getParent().getParent().getTagName();
        } else {
            return null;
        }
    }

    public String getPath() {
        if (this.leafTree != null) {
            TagTree tt = this.leafTree;
            String s = tt.getTagCode();
            while (tt.getParent() != null) {
                tt = tt.getParent();
                s = tt.getTagCode() + " -> " + s;
            }
            return s;
        }
        return null;
    }

    /*************/

}
