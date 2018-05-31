package com.yicai.taotalent.controller;

import com.yicai.taotalent.dao.LiveDatasDao;
import com.yicai.taotalent.domain.Livedatas;
import com.yicai.taotalent.repository.LiveDatasRepository;
import com.yicai.taotalent.utils.PageRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by RamboLi
 * Date 2018/5/6 0006
 * Time 23:40
 */
@RestController
public class LiveDatasController {
    private final static Logger logger= LoggerFactory.getLogger(LiveDatasController.class);
    @Autowired
    private LiveDatasRepository liveDatasRepository;
    @Autowired
    private LiveDatasDao liveDatasDao;
    @GetMapping(value = "/livedatas/{liveId}")
    public Page<Livedatas> getAnchorList(@PathVariable(value = "liveId",required = true) String liveId,
                                         @RequestParam(value = "page",required = false,defaultValue = "1") int page,
                                         @RequestParam(value = "pageSize",required = false,defaultValue = "100" ) int pageSize){
        logger.info("liveId============================"+liveId);
        //构建分页信息
        PageRequest pageRequest = PageRequestUtil.buildPageRequest(page,pageSize,"created");
        Page<Livedatas> liveDatas = liveDatasRepository.findByLiveId(liveId,pageRequest);
        return liveDatas;
    }

    /**
     * livedatas为主表，根据accountId和userId关联查询anchors两个表的信息
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/livedatasanchor")
    public List<Livedatas> getLiveDataAnchorList(@RequestParam(value = "page",required = false,defaultValue = "1") int page,
                                                  @RequestParam(value = "pageSize",required = false,defaultValue = "100" ) int pageSize){
        logger.info("liveId============================"+page);
        //构建分页信息
//        PageRequest pageRequest = PageRequestUtil.buildPageRequest(page,pageSize,"created");
//        Page<Livedatas> liveDatas = liveDatasRepository.findByLiveId(liveId,pageRequest);
        List<Livedatas> livedatasList = liveDatasDao.getLiveDatasAnchorList(page,pageSize);
        return livedatasList;
    }

    /**
     * livedatas为主表，根据liveId和liveId关联查询live2两个表的信息
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/livedataslive")
    public List<Livedatas> getLiveDataLive2List(@RequestParam(value = "page",required = false,defaultValue = "1") int page,
                                                 @RequestParam(value = "pageSize",required = false,defaultValue = "100" ) int pageSize){
        logger.info("liveId============================"+page);
        List<Livedatas> livedatasList = liveDatasDao.getLiveDatasLiveList(page,pageSize);
        return livedatasList;
    }
}
