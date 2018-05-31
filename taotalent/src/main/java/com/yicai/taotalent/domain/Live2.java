package com.yicai.taotalent.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

/**
 * Created by RamboLi
 * Date 2018/5/2 0002
 * Time 19:07
 */
public class Live2 {
//    @Id
//    private String _id;
    private Integer __v;
    @Id
    private String id;
//    @Indexed(unique = true)
//    private String id_1;
    private String accountId;
    private Integer accountScore;
    private Boolean alert;
    private Date appointmentTime;
    private Integer approval;
    private String bizCode;
    private Integer bizStatus;
    private Integer bizTag;
    private String contentType;
    private String coverImg;
    private String coverImg169;
    private Integer curItemNum;
    private Date currentTime;
    private String descInfo;
    private String endPushStreamTime;
    private Date endTime;
    private String favorImg;
    private Boolean free;
    private Boolean fullScreen;
    private String functionType;
    private Date gmtCreateTime;
    private Date gmtModifyTime;
    private String groupChatNum;
    private Boolean hasFollowModule;
    private String headPic;
    private Boolean hideLogo;
    private Integer inputCodeLevel;
    private String inputStreamUrl;
    private String ip;
    private String isPlayerLow;
    private Integer joinCount;
    private Boolean keepAlive;
    private Boolean landScape;
    private Boolean linklivePower;
    private Integer liveChannelId;
    private Integer liveColumnId;
    @NotEmpty(message = "直播ID不能为空")
    private String liveId;
    private Boolean liveLinkage;
    private Boolean liveRoomTheme;
    private String location;
    private String locationFull;
    private Integer maxItemNum;
    private Boolean overSeaBroadCaster;
    private Integer parseCount;
    private Integer praiseCount;
    private String preLive2Id;
    private String publishSource;
    private String renderId;
    private String right;
    private String roomNum;
    private Integer roomStatus;
    private Integer roomType;
    private String rtp;
    private String shareOption;
    private Date startTime;
    private Integer status;              // 0: broadcasting, 1: finished
    private String streamStatus;
    private String tags;
    private String tidbitsUrlType;
    private Integer timeLength;
    private String title;
    private String tmallOnly;
    private String topic;
    private Integer totalJoinCount;
    private Integer type;
    private String videoId;
    private Boolean videoPassed;
    private String videoPlayUrl;
    private Integer viewCount;
    private String weitaoFeedId;
    private String ttid;
    private String longAndLat;
    private Integer digNum;
    private Integer msgNum;
    private Integer onlineNum;
    private Integer totalNum;
    private Integer visitNum;
    private Date updated; //default:now()
    private Date created; //default:now()
    public Live2(Integer __v, String id, String accountId, Integer accountScore, Boolean alert, Date appointmentTime,
                 Integer approval, String bizCode, Integer bizStatus, Integer bizTag, String contentType, String coverImg, String coverImg169,
                 Integer curItemNum, Date currentTime, String descInfo, String endPushStreamTime, Date endTime, String favorImg, Boolean free,
                 Boolean fullScreen, String functionType, Date gmtCreateTime, Date gmtModifyTime, String groupChatNum, Boolean hasFollowModule,
                 String headPic, Boolean hideLogo, Integer inputCodeLevel, String inputStreamUrl, String ip, String isPlayerLow,
                 Integer joinCount, Boolean keepAlive, Boolean landScape, Boolean linklivePower, Integer liveChannelId, Integer liveColumnId,
                 String liveId, Boolean liveLinkage, Boolean liveRoomTheme, String location, String locationFull, Integer maxItemNum,
                 Boolean overSeaBroadCaster, Integer parseCount, Integer praiseCount, String preLive2Id, String publishSource, String renderId,
                 String right, String roomNum, Integer roomStatus, Integer roomType, String rtp, String shareOption, Date startTime,
                 Integer status, String streamStatus, String tags, String tidbitsUrlType, Integer timeLength, String title, String tmallOnly,
                 String topic, Integer totalJoinCount, Integer type, String videoId, Boolean videoPassed, String videoPlayUrl,
                 Integer viewCount, String weitaoFeedId, String ttid, String longAndLat, Integer digNum, Integer msgNum, Integer onlineNum,
                 Integer totalNum, Integer visitNum, Date updated, Date created) {
//        this._id = _id;
        this.__v = __v;
        this.id = id;
//        this.id_1=id_1;
        this.accountId = accountId;
        this.accountScore = accountScore;
        this.alert = alert;
        this.appointmentTime = appointmentTime;
        this.approval = approval;
        this.bizCode = bizCode;
        this.bizStatus = bizStatus;
        this.bizTag = bizTag;
        this.contentType = contentType;
        this.coverImg = coverImg;
        this.coverImg169 = coverImg169;
        this.curItemNum = curItemNum;
        this.currentTime = currentTime;
        this.descInfo = descInfo;
        this.endPushStreamTime = endPushStreamTime;
        this.endTime = endTime;
        this.favorImg = favorImg;
        this.free = free;
        this.fullScreen = fullScreen;
        this.functionType = functionType;
        this.gmtCreateTime = gmtCreateTime;
        this.gmtModifyTime = gmtModifyTime;
        this.groupChatNum = groupChatNum;
        this.hasFollowModule = hasFollowModule;
        this.headPic = headPic;
        this.hideLogo = hideLogo;
        this.inputCodeLevel = inputCodeLevel;
        this.inputStreamUrl = inputStreamUrl;
        this.ip = ip;
        this.isPlayerLow = isPlayerLow;
        this.joinCount = joinCount;
        this.keepAlive = keepAlive;
        this.landScape = landScape;
        this.linklivePower = linklivePower;
        this.liveChannelId = liveChannelId;
        this.liveColumnId = liveColumnId;
        this.liveId = liveId;
        this.liveLinkage = liveLinkage;
        this.liveRoomTheme = liveRoomTheme;
        this.location = location;
        this.locationFull = locationFull;
        this.maxItemNum = maxItemNum;
        this.overSeaBroadCaster = overSeaBroadCaster;
        this.parseCount = parseCount;
        this.praiseCount = praiseCount;
        this.preLive2Id = preLive2Id;
        this.publishSource = publishSource;
        this.renderId = renderId;
        this.right = right;
        this.roomNum = roomNum;
        this.roomStatus = roomStatus;
        this.roomType = roomType;
        this.rtp = rtp;
        this.shareOption = shareOption;
        this.startTime = startTime;
        this.status = status;
        this.streamStatus = streamStatus;
        this.tags = tags;
        this.tidbitsUrlType = tidbitsUrlType;
        this.timeLength = timeLength;
        this.title = title;
        this.tmallOnly = tmallOnly;
        this.topic = topic;
        this.totalJoinCount = totalJoinCount;
        this.type = type;
        this.videoId = videoId;
        this.videoPassed = videoPassed;
        this.videoPlayUrl = videoPlayUrl;
        this.viewCount = viewCount;
        this.weitaoFeedId = weitaoFeedId;
        this.ttid = ttid;
        this.longAndLat = longAndLat;
        this.digNum = digNum;
        this.msgNum = msgNum;
        this.onlineNum = onlineNum;
        this.totalNum = totalNum;
        this.visitNum = visitNum;
        this.updated = updated;
        this.created = created;
    }
    public Live2() {
    }

    public Integer get__v() {
        return __v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getAccountScore() {
        return accountScore;
    }

    public void setAccountScore(Integer accountScore) {
        this.accountScore = accountScore;
    }

    public Boolean getAlert() {
        return alert;
    }

    public void setAlert(Boolean alert) {
        this.alert = alert;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Integer getApproval() {
        return approval;
    }

    public void setApproval(Integer approval) {
        this.approval = approval;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public Integer getBizStatus() {
        return bizStatus;
    }

    public void setBizStatus(Integer bizStatus) {
        this.bizStatus = bizStatus;
    }

    public Integer getBizTag() {
        return bizTag;
    }

    public void setBizTag(Integer bizTag) {
        this.bizTag = bizTag;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getCoverImg169() {
        return coverImg169;
    }

    public void setCoverImg169(String coverImg169) {
        this.coverImg169 = coverImg169;
    }

    public Integer getCurItemNum() {
        return curItemNum;
    }

    public void setCurItemNum(Integer curItemNum) {
        this.curItemNum = curItemNum;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo;
    }

    public String getEndPushStreamTime() {
        return endPushStreamTime;
    }

    public void setEndPushStreamTime(String endPushStreamTime) {
        this.endPushStreamTime = endPushStreamTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getFavorImg() {
        return favorImg;
    }

    public void setFavorImg(String favorImg) {
        this.favorImg = favorImg;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public Boolean getFullScreen() {
        return fullScreen;
    }

    public void setFullScreen(Boolean fullScreen) {
        this.fullScreen = fullScreen;
    }

    public String getFunctionType() {
        return functionType;
    }

    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }

    public Date getGmtCreateTime() {
        return gmtCreateTime;
    }

    public void setGmtCreateTime(Date gmtCreateTime) {
        this.gmtCreateTime = gmtCreateTime;
    }

    public Date getGmtModifyTime() {
        return gmtModifyTime;
    }

    public void setGmtModifyTime(Date gmtModifyTime) {
        this.gmtModifyTime = gmtModifyTime;
    }

    public String getGroupChatNum() {
        return groupChatNum;
    }

    public void setGroupChatNum(String groupChatNum) {
        this.groupChatNum = groupChatNum;
    }

    public Boolean getHasFollowModule() {
        return hasFollowModule;
    }

    public void setHasFollowModule(Boolean hasFollowModule) {
        this.hasFollowModule = hasFollowModule;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public Boolean getHideLogo() {
        return hideLogo;
    }

    public void setHideLogo(Boolean hideLogo) {
        this.hideLogo = hideLogo;
    }

    public Integer getInputCodeLevel() {
        return inputCodeLevel;
    }

    public void setInputCodeLevel(Integer inputCodeLevel) {
        this.inputCodeLevel = inputCodeLevel;
    }

    public String getInputStreamUrl() {
        return inputStreamUrl;
    }

    public void setInputStreamUrl(String inputStreamUrl) {
        this.inputStreamUrl = inputStreamUrl;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIsPlayerLow() {
        return isPlayerLow;
    }

    public void setIsPlayerLow(String isPlayerLow) {
        this.isPlayerLow = isPlayerLow;
    }

    public Integer getJoinCount() {
        return joinCount;
    }

    public void setJoinCount(Integer joinCount) {
        this.joinCount = joinCount;
    }

    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getLandScape() {
        return landScape;
    }

    public void setLandScape(Boolean landScape) {
        this.landScape = landScape;
    }

    public Boolean getLinklivePower() {
        return linklivePower;
    }

    public void setLinklivePower(Boolean linklivePower) {
        this.linklivePower = linklivePower;
    }

    public Integer getLiveChannelId() {
        return liveChannelId;
    }

    public void setLiveChannelId(Integer liveChannelId) {
        this.liveChannelId = liveChannelId;
    }

    public Integer getLiveColumnId() {
        return liveColumnId;
    }

    public void setLiveColumnId(Integer liveColumnId) {
        this.liveColumnId = liveColumnId;
    }

    public String getLiveId() {
        return liveId;
    }

    public void setLiveId(String liveId) {
        this.liveId = liveId;
    }

    public Boolean getLiveLinkage() {
        return liveLinkage;
    }

    public void setLiveLinkage(Boolean liveLinkage) {
        this.liveLinkage = liveLinkage;
    }

    public Boolean getLiveRoomTheme() {
        return liveRoomTheme;
    }

    public void setLiveRoomTheme(Boolean liveRoomTheme) {
        this.liveRoomTheme = liveRoomTheme;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationFull() {
        return locationFull;
    }

    public void setLocationFull(String locationFull) {
        this.locationFull = locationFull;
    }

    public Integer getMaxItemNum() {
        return maxItemNum;
    }

    public void setMaxItemNum(Integer maxItemNum) {
        this.maxItemNum = maxItemNum;
    }

    public Boolean getOverSeaBroadCaster() {
        return overSeaBroadCaster;
    }

    public void setOverSeaBroadCaster(Boolean overSeaBroadCaster) {
        this.overSeaBroadCaster = overSeaBroadCaster;
    }

    public Integer getParseCount() {
        return parseCount;
    }

    public void setParseCount(Integer parseCount) {
        this.parseCount = parseCount;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public String getPreLive2Id() {
        return preLive2Id;
    }

    public void setPreLive2Id(String preLive2Id) {
        this.preLive2Id = preLive2Id;
    }

    public String getPublishSource() {
        return publishSource;
    }

    public void setPublishSource(String publishSource) {
        this.publishSource = publishSource;
    }

    public String getRenderId() {
        return renderId;
    }

    public void setRenderId(String renderId) {
        this.renderId = renderId;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public String getRtp() {
        return rtp;
    }

    public void setRtp(String rtp) {
        this.rtp = rtp;
    }

    public String getShareOption() {
        return shareOption;
    }

    public void setShareOption(String shareOption) {
        this.shareOption = shareOption;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStreamStatus() {
        return streamStatus;
    }

    public void setStreamStatus(String streamStatus) {
        this.streamStatus = streamStatus;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTidbitsUrlType() {
        return tidbitsUrlType;
    }

    public void setTidbitsUrlType(String tidbitsUrlType) {
        this.tidbitsUrlType = tidbitsUrlType;
    }

    public Integer getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(Integer timeLength) {
        this.timeLength = timeLength;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTmallOnly() {
        return tmallOnly;
    }

    public void setTmallOnly(String tmallOnly) {
        this.tmallOnly = tmallOnly;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getTotalJoinCount() {
        return totalJoinCount;
    }

    public void setTotalJoinCount(Integer totalJoinCount) {
        this.totalJoinCount = totalJoinCount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public Boolean getVideoPassed() {
        return videoPassed;
    }

    public void setVideoPassed(Boolean videoPassed) {
        this.videoPassed = videoPassed;
    }

    public String getVideoPlayUrl() {
        return videoPlayUrl;
    }

    public void setVideoPlayUrl(String videoPlayUrl) {
        this.videoPlayUrl = videoPlayUrl;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getWeitaoFeedId() {
        return weitaoFeedId;
    }

    public void setWeitaoFeedId(String weitaoFeedId) {
        this.weitaoFeedId = weitaoFeedId;
    }

    public String getTtid() {
        return ttid;
    }

    public void setTtid(String ttid) {
        this.ttid = ttid;
    }

    public String getLongAndLat() {
        return longAndLat;
    }

    public void setLongAndLat(String longAndLat) {
        this.longAndLat = longAndLat;
    }

    public Integer getDigNum() {
        return digNum;
    }

    public void setDigNum(Integer digNum) {
        this.digNum = digNum;
    }

    public Integer getMsgNum() {
        return msgNum;
    }

    public void setMsgNum(Integer msgNum) {
        this.msgNum = msgNum;
    }

    public Integer getOnlineNum() {
        return onlineNum;
    }

    public void setOnlineNum(Integer onlineNum) {
        this.onlineNum = onlineNum;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(Integer visitNum) {
        this.visitNum = visitNum;
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
