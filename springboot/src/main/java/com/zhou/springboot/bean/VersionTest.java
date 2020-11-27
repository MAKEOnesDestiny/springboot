package com.zhou.springboot.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VersionTest {

    @Id
    private int id;

    private String seq;

    private int version;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
