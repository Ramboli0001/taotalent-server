package com.yicai.taotalent.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by RamboLi
 * Date 2018/5/6 0006
 * Time 23:30
 */
public class Livedatas {
    @Id
    private String id;
    private String liveId;
    private String accountId;
    private String stat;
    private String[] comments;
    private Date updated;
    private Date created;
    private String[] anchorslist;
    private String[] live2list;
    public Livedatas(String id, String liveId, String accountId, String stat, String[] comments, Date updated,
                     Date created, String[] anchorslist,String[] live2list) {
        this.id = id;
        this.liveId = liveId;
        this.accountId = accountId;
        this.stat = stat;
        this.comments = comments;
        this.updated = updated;
        this.created = created;
        this.anchorslist = anchorslist;
        this.live2list = live2list;
    }

    public Livedatas() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLiveId() {
        return liveId;
    }

    public void setLiveId(String liveId) {
        this.liveId = liveId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }


    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String[] getAnchorslist() {
        return anchorslist;
    }

    public void setAnchorslist(String[] anchorslist) {
        this.anchorslist = anchorslist;
    }

    public String[] getLive2list() {
        return live2list;
    }

    public void setLive2list(String[] live2list) {
        this.live2list = live2list;
    }
}
