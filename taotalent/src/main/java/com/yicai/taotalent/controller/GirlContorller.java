package com.yicai.taotalent.controller;

import com.yicai.taotalent.domain.Girl;
import com.yicai.taotalent.repository.GirlRepository;
import com.yicai.taotalent.service.GirlService;
import com.yicai.taotalent.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import com.yicai.taotalent.domain.Result;
import java.util.List;
import java.util.Random;

/**
 * Created by RamboLi
 * Date 2018/4/19 0019
 * Time 16:55
 */
@RestController
public class GirlContorller {
    @Autowired
    private GirlRepository girlRepository;
    private final static Logger logger = LoggerFactory.getLogger(GirlContorller.class);
    /**
     * 保存人员信息
     */
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public void saveUser(){
        Random random=new Random();
        girlRepository.insert(new Girl(random.nextInt(100000),"liuyan",35));
    }

    /**
     * 查询人员信息列表
     * @return
     */
    @RequestMapping(value = "/girllist",method = RequestMethod.GET)
    public List<Girl> girlList(){
//        System.out.println("2222222222222222222");
        logger.info("222222222222222222222200");
        return girlRepository.findAll();
    }
    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public Girl addUser(@RequestParam(value = "id",required = true,defaultValue = "0") Integer myid,
                         @RequestParam(value = "userName") String userName,@RequestParam(value = "age") Integer agett){
        Girl girl=new Girl();
        girl.setId(myid);
        girl.setUserName(userName);
        girl.setAge(agett);
        girlRepository.insert(girl);
        return girl;
    }
    @PostMapping(value = "/adduser2")
    public Girl addUser2(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
//            System.out.println(bindingResult.getFieldError().getDefaultMessage());

            return girl;
        }
        girl.setAge(girl.getAge());
        girl.setUserName(girl.getUserName());
        girl.setId(girl.getId());
        return girlRepository.save(girl);
    }
    @PostMapping(value = "/adduser3")
    public Result<Girl> addUser3(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Result result=new Result();
            result.setCode(1);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }

        girl.setAge(girl.getAge());
        girl.setUserName(girl.getUserName());
        girl.setId(girl.getId());
        Result result=new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(girlRepository.save(girl));
        return result;
    }

    /**
     * 优化addUser3
     * @param girl
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/adduser4")
    public Result<Girl> addUser4(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setAge(girl.getAge());
        girl.setUserName(girl.getUserName());
        girl.setId(girl.getId());
        return ResultUtil.success(girlRepository.save(girl));
    }
    @PutMapping(value = "/updateuser/{id}")
    public Girl updateUser(@PathVariable(value = "id") Integer uid,
                             @RequestParam(value = "userName") String userName,
                             @RequestParam(value = "age") Integer age){
        Girl girl =new Girl();
        girl.setId(uid);
        girl.setUserName(userName);
        girl.setAge(age);
        return girlRepository.save(girl);
    }
    @DeleteMapping(value = "/deleteuser/{id}")
    public void deleteUser(@PathVariable(value = "id") Integer did){
        girlRepository.delete(did);
    }
    @GetMapping(value = "/getuserbyage/{age}")
    public List<Girl> getGirlByAge(@PathVariable(value = "age") Integer age){
        return girlRepository.getGirlsByAge(age);
    }
    @Autowired
    private GirlService girlService;
    @PostMapping(value = "/savetwo")
    public void saveTwo(){
        girlService.insertTwo();
    }
    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable(value = "id") Integer gid) throws Exception{
        girlService.getAgeById(gid);
    }
}
