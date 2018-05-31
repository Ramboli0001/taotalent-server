package com.yicai.taotalent.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by RamboLi
 * Date 2018/5/2 0002
 * Time 18:30
 */
public class Anchors {
    @Id
    private String id;
    @NotEmpty(message = "主播ID不能为空")
    private String userId;
    private Integer __v;
    private String headBackgroundImage;
    private String[] replays;
    private String nickName;
    private String headImageURL;
//    @Min(value = 10,message = "粉丝数不能小于100")
    private Integer fansNum;
    private Integer liveNum;
    private String agencyId;
    private boolean hasShop;
    private boolean tmall;
    private String type;
    private boolean v;
    private Date created; //default:now()
    private Date updated; //default:now()
    public Anchors() {
    }
    public Anchors(String id, String userId, Integer __v, String headBackgroundImage, String[] replays,
                   String nickName, String headImageURL, Integer fansNum, Integer liveNum, String agencyId,
                   boolean hasShop, boolean tmall, String type, boolean v, Date created, Date updated) {
        this.id = id;
        this.userId = userId;
        this.__v = __v;
        this.headBackgroundImage = headBackgroundImage;
        this.replays = replays;
        this.nickName = nickName;
        this.headImageURL = headImageURL;
        this.fansNum = fansNum;
        this.liveNum = liveNum;
        this.agencyId = agencyId;
        this.hasShop = hasShop;
        this.tmall = tmall;
        this.type = type;
        this.v = v;
        this.created = created;
        this.updated = updated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer get__v() {
        return __v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }

    public String getHeadBackgroundImage() {
        return headBackgroundImage;
    }

    public void setHeadBackgroundImage(String headBackgroundImage) {
        this.headBackgroundImage = headBackgroundImage;
    }

    public String[] getReplays() {
        return replays;
    }

    public void setReplays(String[] replays) {
        this.replays = replays;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImageURL() {
        return headImageURL;
    }

    public void setHeadImageURL(String headImageURL) {
        this.headImageURL = headImageURL;
    }

    public Integer getFansNum() {
        return fansNum;
    }

    public void setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
    }

    public Integer getLiveNum() {
        return liveNum;
    }

    public void setLiveNum(Integer liveNum) {
        this.liveNum = liveNum;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public boolean isHasShop() {
        return hasShop;
    }

    public void setHasShop(boolean hasShop) {
        this.hasShop = hasShop;
    }

    public boolean isTmall() {
        return tmall;
    }

    public void setTmall(boolean tmall) {
        this.tmall = tmall;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isV() {
        return v;
    }

    public void setV(boolean v) {
        this.v = v;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }


}
