package com.yicai.taotalent.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by RamboLi
 * Date 2018/5/3 0003
 * Time 11:01
 */
public class Livedetails {
    @Id
    private String id;
    private String liveId;
    private String userId;
    private String user; //主播ID
    private String title;
    private String location;
    private String coverImage;
    private String accountDes;
    private Integer accountScore;
    private Date startDate;
    private Integer duration;
    private Integer liveChannelId;
    private Integer curItemNum;
    private Date ts;
    private Integer liveColumnId;
    private Integer praiseCount;
    private Integer uv;
    private Integer pv;
    private Integer joinCount;
    private Integer fansNum;
    private String status;
    private String[] products;
    private String raw;
    private Date updated;
    private Date created;
    public Livedetails(String id, String liveId, String userId, String user, String title, String location, String coverImage, String accountDes,
                       Integer accountScore, Date startDate, Integer duration, Integer liveChannelId, Integer curItemNum, Date ts,
                       Integer liveColumnId, Integer praiseCount, Integer uv, Integer pv, Integer joinCount, Integer fansNum, String status,
                       String[] products, String raw, Date updated, Date created) {
        this.id = id;
        this.liveId = liveId;
        this.userId = userId;
        this.user = user;
        this.title = title;
        this.location = location;
        this.coverImage = coverImage;
        this.accountDes = accountDes;
        this.accountScore = accountScore;
        this.startDate = startDate;
        this.duration = duration;
        this.liveChannelId = liveChannelId;
        this.curItemNum = curItemNum;
        this.ts = ts;
        this.liveColumnId = liveColumnId;
        this.praiseCount = praiseCount;
        this.uv = uv;
        this.pv = pv;
        this.joinCount = joinCount;
        this.fansNum = fansNum;
        this.status = status;
        this.products = products;
        this.raw = raw;
        this.updated = updated;
        this.created = created;
    }

    public Livedetails() {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getAccountDes() {
        return accountDes;
    }

    public void setAccountDes(String accountDes) {
        this.accountDes = accountDes;
    }

    public Integer getAccountScore() {
        return accountScore;
    }

    public void setAccountScore(Integer accountScore) {
        this.accountScore = accountScore;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getLiveChannelId() {
        return liveChannelId;
    }

    public void setLiveChannelId(Integer liveChannelId) {
        this.liveChannelId = liveChannelId;
    }

    public Integer getCurItemNum() {
        return curItemNum;
    }

    public void setCurItemNum(Integer curItemNum) {
        this.curItemNum = curItemNum;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Integer getLiveColumnId() {
        return liveColumnId;
    }

    public void setLiveColumnId(Integer liveColumnId) {
        this.liveColumnId = liveColumnId;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Integer getUv() {
        return uv;
    }

    public void setUv(Integer uv) {
        this.uv = uv;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getJoinCount() {
        return joinCount;
    }

    public void setJoinCount(Integer joinCount) {
        this.joinCount = joinCount;
    }

    public Integer getFansNum() {
        return fansNum;
    }

    public void setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getProducts() {
        return products;
    }

    public void setProducts(String[] products) {
        this.products = products;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
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


}
