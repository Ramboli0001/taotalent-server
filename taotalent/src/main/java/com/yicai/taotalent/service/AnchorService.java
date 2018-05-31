package com.yicai.taotalent.service;

import com.yicai.taotalent.domain.Anchors;
import com.yicai.taotalent.enums.ResultEnum;
import com.yicai.taotalent.exception.AnchorsException;
import com.yicai.taotalent.repository.AnchorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by RamboLi
 * Date 2018/5/3 0003
 * Time 16:17
 */
@Service
public class AnchorService {
    @Autowired
    private AnchorRepository anchorRepository;
    private final static Logger logger = LoggerFactory.getLogger(AnchorService.class);
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
