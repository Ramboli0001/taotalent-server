package com.yicai.taotalent.controller;

import com.yicai.taotalent.dao.AnchorsDao;
import com.yicai.taotalent.domain.Anchors;
import com.yicai.taotalent.domain.Girl;
import com.yicai.taotalent.domain.Result;
import com.yicai.taotalent.enums.PageableEnum;
import com.yicai.taotalent.repository.AnchorRepository;
import com.yicai.taotalent.service.AnchorService;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by RamboLi
 * Date 2018/5/3 0003
 * Time 11:24
 */
@RestController
//@RequestMapping(value = "/anchors")
public class AnchorsController {
    private final static Logger logger=LoggerFactory.getLogger(AnchorsController.class);
    @Autowired
    private AnchorRepository anchorRepository;
    @Autowired
    private AnchorService anchorService;
    @Autowired
    private AnchorsDao anchorsDao;
    /**
     * 增加主播
     * @param anchors
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/anchors")
//    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Result<Anchors> addAnchor(@Valid Anchors anchors, BindingResult bindingResult) throws Exception{
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        anchorService.checkAnchorId(anchors.getUserId());
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
//    @PostMapping(value = "/checkanchor")
//    public void checkAnchor(@Valid Anchors anchors)throws Exception{
//        anchorService.checkAnchorId(anchors.getUserId());
//    }
//    @GetMapping(value = "/checkanc/{id}")
//    public void getAge(@PathVariable(value = "id") String gid) throws Exception{
//        anchorService.checkAnchorId(gid);
//    }

//    @PutMapping(value = "/updateuser/{id}")
//    public Girl updateUser(@PathVariable(value = "id") Integer uid,
//                           @RequestParam(value = "userName") String userName,
//                           @RequestParam(value = "age") Integer age){
//        Girl girl =new Girl();
//        girl.setId(uid);
//        girl.setUserName(userName);
//        girl.setAge(age);
//        return girlRepository.save(girl);
//    }
    @PostMapping(value = "/anchorsup")
    public Result<Anchors> modAnchor(@Valid Anchors anchors, BindingResult bindingResult) throws Exception{
        logger.info("主播ID是--------------"+anchors.getUserId());
//        anchorService.checkAnchorId(anchors.getUserId());
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        Anchors anchors1=anchorRepository.getAnchorsByUserId(anchors.getUserId()); //userid不可修改，需要在前端控制。
        anchors1.setAgencyId(anchors.getAgencyId());
        anchors1.setFansNum(anchors.getFansNum());
        anchors1.setHasShop(anchors.isHasShop());
        anchors1.setHeadBackgroundImage(anchors.getHeadBackgroundImage());
        anchors1.setHeadImageURL(anchors.getHeadImageURL());
        anchors1.setLiveNum(anchors.getLiveNum());
        anchors1.setNickName(anchors.getNickName());
        anchors1.setReplays(anchors.getReplays());
        anchors1.setTmall(anchors.isTmall());
        anchors1.setType(anchors.getType());
//        anchors1.setUserId(anchors.getUserId());
        anchors1.setV(anchors.isV());
        anchors1.setUpdated(new Date());
        anchors1.setCreated(new Date());
        return ResultUtil.success(anchorRepository.save(anchors1));
    }
    //Mongodb提供了两种增加数据的方式，分别是save和insert。其区别是：insert当主键ID存在时，不做任何处理，直接抛出异常；
    // save当主键ID存在时做更新操作，否则做保存操作。

//    /**
//     *根据主键ID删除
//     * @param id
//     */
//    @DeleteMapping(value = "/anchors/{id}")
//    public void deleteAnchor(@PathVariable(value = "id") String aid){
//        anchorRepository.delete(aid);
//    }

//    @RequestMapping("/selectBygender")
    @GetMapping(value = "/anchorsy")
    public Page<Anchors> getByType(@RequestParam(value = "type") String type, @RequestParam("page") int pageNumber){
        //构建分页信息
        logger.info("leixingshi===="+type);
        PageRequest pageRequest = PageRequestUtil.buildPageRequest(pageNumber,5,"created");
        Page<Anchors> anchors = anchorRepository.findByType(type,pageRequest);
        return anchors;
    }

    /**
     * 主播列表分页
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/anchors")
    public Page<Anchors> getAnchorList(@RequestParam(value = "page",required = false,defaultValue = "1") int page,
                                        @RequestParam(value = "pageSize",required = false,defaultValue = "100" ) int pageSize){
        //构建分页信息
        PageRequest pageRequest = PageRequestUtil.buildPageRequest(page,pageSize,"created");
        Page<Anchors> anchors = anchorRepository.findAll(pageRequest);
        return anchors;
    }

    /**
     * 根据主键ID查询单个信息
     * @param id
     * @return
     */
    @GetMapping("/anchors/{id}")
    public Anchors getAnchorById(@PathVariable(value = "id",required = true) String id){
        Anchors anchors = anchorRepository.findOne(id);
        return anchors;
    }

    @GetMapping("/getanchorlist")
    public List<Anchors> getAnchorList2(@RequestParam(value = "page",required = false,defaultValue = "1") int page,
                                        @RequestParam(value = "pageSize",required = false,defaultValue = "100" ) int pageSize){
        return anchorsDao.getAnchorsList(page,pageSize);
    }
}
