package com.yicai.taotalent.controller;

import com.yicai.taotalent.domain.Live2;
import com.yicai.taotalent.domain.Result;
import com.yicai.taotalent.repository.Live2Repository;
import com.yicai.taotalent.service.Live2Service;
import com.yicai.taotalent.utils.PageRequestUtil;
import com.yicai.taotalent.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by RamboLi
 * Date 2018/5/3 0003
 * Time 23:14
 */
@RestController
//@RequestMapping(value = "/live")
public class Live2Controller {
    private final static Logger logger = LoggerFactory.getLogger(Live2Controller.class);
    @Autowired
    private Live2Repository live2Repository;
    @Autowired
    private Live2Service live2Service;

    /**
     * 增加直播信息
     * @param live2
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/live")
    public Result<Live2> addLive(@Valid Live2 live2, BindingResult bindingResult) throws Exception{
        live2Service.checkLiveId(live2.getLiveId());
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        live2.setAccountId(live2.getAccountId());
        live2.setAccountScore(live2.getAccountScore());
        live2.setAlert(live2.getAlert());
        live2.setAppointmentTime(new Date());
        live2.setApproval(live2.getApproval());
        live2.setBizCode(live2.getBizCode());
        live2.setBizStatus(live2.getBizStatus());
        live2.setBizTag(live2.getBizTag());
        live2.setContentType(live2.getContentType());
        live2.setCoverImg(live2.getCoverImg());
        live2.setCoverImg169(live2.getCoverImg169());
        live2.setCreated(new Date());
        live2.setCurItemNum(live2.getCurItemNum());
        live2.setCurrentTime(new Date());
        live2.setDescInfo(live2.getDescInfo());
        live2.setDigNum(live2.getDigNum());
        live2.setEndPushStreamTime(live2.getEndPushStreamTime());
        live2.setEndTime(new Date());
        live2.setFavorImg(live2.getFavorImg());
        live2.setFree(live2.getFree());
        live2.setFullScreen(live2.getFullScreen());
        live2.setFunctionType(live2.getFunctionType());
        live2.setGmtCreateTime(new Date());
        live2.setGmtModifyTime(new Date());
        live2.setGroupChatNum(live2.getGroupChatNum());
        live2.setHasFollowModule(live2.getHasFollowModule());
        live2.setHeadPic(live2.getHeadPic());
        live2.setHideLogo(live2.getHideLogo());
        live2.setId(live2.getId());
//        live2.setId_1(live2.getId_1());
        live2.setInputCodeLevel(live2.getInputCodeLevel());
        live2.setInputStreamUrl(live2.getInputStreamUrl());
        live2.setIp(live2.getIp());
        live2.setIsPlayerLow(live2.getIsPlayerLow());
        live2.setJoinCount(live2.getJoinCount());
        live2.setKeepAlive(live2.getKeepAlive());
        live2.setLandScape(live2.getLandScape());
        live2.setLinklivePower(live2.getLinklivePower());
        live2.setLiveChannelId(live2.getLiveChannelId());
        live2.setLiveColumnId(live2.getLiveColumnId());
        live2.setLiveId(live2.getLiveId());
        live2.setLiveLinkage(live2.getLiveLinkage());
        live2.setLiveRoomTheme(live2.getLiveRoomTheme());
        live2.setLocation(live2.getLocation());
        live2.setLocationFull(live2.getLocationFull());
        live2.setLongAndLat(live2.getLongAndLat());
        live2.setMaxItemNum(live2.getMaxItemNum());
        live2.setMsgNum(live2.getMsgNum());
        live2.setOverSeaBroadCaster(live2.getOverSeaBroadCaster());
        live2.setParseCount(live2.getParseCount());
        live2.setPraiseCount(live2.getPraiseCount());
        live2.setPreLive2Id(live2.getPreLive2Id());
        live2.setPublishSource(live2.getPublishSource());
        live2.setRenderId(live2.getRenderId());
        live2.setRight(live2.getRight());
        live2.setRoomNum(live2.getRoomNum());
        live2.setRoomStatus(live2.getRoomStatus());
        live2.setRoomType(live2.getRoomType());
        live2.setRtp(live2.getRtp());
        live2.setShareOption(live2.getShareOption());
        live2.setStartTime(live2.getStartTime());
        live2.setStreamStatus(live2.getStreamStatus());
        live2.setTags(live2.getTags());
        live2.setTidbitsUrlType(live2.getTidbitsUrlType());
        live2.setTimeLength(live2.getTimeLength());
        live2.setTitle(live2.getTitle());
        live2.setTmallOnly(live2.getTmallOnly());
        live2.setTopic(live2.getTopic());
        live2.setTotalJoinCount(live2.getTotalJoinCount());
        live2.setTotalNum(live2.getTotalNum());
        live2.setTtid(live2.getTtid());
        live2.setType(live2.getType());
        live2.setUpdated(new Date());
        live2.setVideoId(live2.getVideoId());
        live2.setVideoPassed(live2.getVideoPassed());
        live2.setVideoPlayUrl(live2.getVideoPlayUrl());
        live2.setViewCount(live2.getViewCount());
        live2.setVisitNum(live2.getVisitNum());
        live2.setWeitaoFeedId(live2.getWeitaoFeedId());
        live2.set__v(live2.get__v());

        return ResultUtil.success(live2Repository.insert(live2));
    }

//    @DeleteMapping(value = "/live/{id}")
//    public void deleteLive(@PathVariable(value = "id") String liveid){
//        live2Repository.delete(liveid);
//    }

    /**
     * 直播列表分页
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/live")
    public Page<Live2> getLiveList(@RequestParam(value = "page",required = false,defaultValue = "1") int page,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "100") int pageSize){
        //构建分页信息
        PageRequest pageRequest = PageRequestUtil.buildPageRequest(page,pageSize,"created");
        Page<Live2> live2 = live2Repository.findAll(pageRequest);
        return live2;
    }

    /**
     * 根据主键ID查询单条信息
     * @param id
     * @return
     */
    @GetMapping("/live/{id}")
    public Live2 getLiveById(@PathVariable(value = "id",required = true) String id){
        Live2 live2 = live2Repository.findOne(id);
        return live2;
    }

}
