package com.yicai.taotalent.service;

import com.yicai.taotalent.domain.Anchors;
import com.yicai.taotalent.domain.Live2;
import com.yicai.taotalent.enums.ResultEnum;
import com.yicai.taotalent.exception.Live2Exception;
import com.yicai.taotalent.repository.Live2Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by RamboLi
 * Date 2018/5/3 0003
 * Time 23:25
 */
@Service
public class Live2Service {
    @Autowired
    private Live2Repository live2Repository;
    private final static Logger logger = LoggerFactory.getLogger(Live2Service.class);
    public void checkLiveId(String liveid) throws Exception{
        logger.info("直播哦哦哦哦哦哦ID====="+liveid);
        Live2 live2 = live2Repository.getLive2ByLiveId(liveid);
//        Anchors anchors = anchorRepository.findOne(anchorid);
        logger.info("直播党***************是"+live2);
        if(live2 != null){
            throw new Live2Exception(ResultEnum.ANCHORID_EXIST);
        }
    }
}
