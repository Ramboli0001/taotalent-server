package com.yicai.taotalent.service.impl;

import com.yicai.taotalent.domain.Anchors;
import com.yicai.taotalent.domain.Result;
import com.yicai.taotalent.enums.ResultEnum;
import com.yicai.taotalent.exception.AnchorsException;
import com.yicai.taotalent.repository.AnchorRepository;
import com.yicai.taotalent.service.AnchorRestService;
import com.yicai.taotalent.service.AnchorService;
import com.yicai.taotalent.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by RamboLi
 * Date 2018/5/4 0004
 * Time 21:50
 */
@RestController
public class AnchorRestServiceImpl implements AnchorRestService {
    @Autowired
    private AnchorRepository anchorRepository;
//    @Autowired
//    private AnchorService anchorService;
    private final static Logger logger = LoggerFactory.getLogger(AnchorService.class);
//    @PostMapping(value = "/addanchor")
    @Override
    public Result<Anchors> postAnchor(@Valid Anchors anchors, BindingResult bindingResult) throws Exception{
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        checkAnchorId(anchors.getUserId());
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        anchors.setAgencyId(anchors.getAgencyId());
        anchors.setFansNum(anchors.getFansNum());
        anchors.setHasShop(anchors.isHasShop());
        anchors.setHeadBackgroundImage(anchors.getHeadBackgroundImage());
        anchors.setHeadImageURL(anchors.getHeadImageURL());
        anchors.setLiveNum(anchors.getLiveNum());
        anchors.setNickName(anchors.getNickName());
        anchors.setReplays(anchors.getReplays());
        anchors.setTmall(anchors.isTmall());
        anchors.setType(anchors.getType());
        anchors.setUserId(anchors.getUserId());
        anchors.setV(anchors.isV());
        anchors.setUpdated(new Date());
        anchors.setCreated(new Date());
        return ResultUtil.success(anchorRepository.insert(anchors));
    }
//    @Override
//    public String postUser(@ModelAttribute Anchors user) {
////        users.put(user.getId(), user);
//        return "success";
//    }
    public void checkAnchorId(String anchorid) throws Exception{
        logger.info("主播ID====="+anchorid);
        Anchors anchors = anchorRepository.getAnchorsByUserId(anchorid);
//        Anchors anchors = anchorRepository.findOne(anchorid);
        logger.info("zhubo***************是"+anchors);
        if(anchors != null){
            throw new AnchorsException(ResultEnum.ANCHORID_EXIST);
        }
    }
}
