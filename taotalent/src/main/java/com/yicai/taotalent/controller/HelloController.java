package com.yicai.taotalent.controller;

import com.yicai.taotalent.properties.girlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * RestController是Spring4.0以后的版本新增的注解方式，功能等同于之前版本的注解@Controller+@ResponseBody
 */
//@RestController
@Controller
@RequestMapping("/hello")
//@ResponseBody
public class HelloController {
//    @Value("${cupSize}")
//    private String cupSize;
//    @Value("${age}")
//    private Integer age;
//    @Value("${content}")
//    private String content;
    @Autowired
    private girlProperties girlproperties;
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String say(){
//        return "Hello Spring Boot!!!";
//        return cupSize+age;
//        return content;
//        return girlproperties.getCupSize()+"...."+girlproperties.getAge();
        System.out.println("8888888888888888888888888888888888");
        return "index";
    }
    @GetMapping("/datatable")
    public String say2(){
        return "data-table";
    }
    @RequestMapping(value={"/hello1","/hello2"},method = RequestMethod.GET)
    @ResponseBody
    public String say1(){
        return girlproperties.getAge()+"以上是hello1或者hello2输出";
    }

    @RequestMapping(value = "/say3",method = RequestMethod.GET)
    @ResponseBody
    public String say3(){
        return girlproperties.getAge()+"<---hello3";
    }

    @RequestMapping(value = "/say4/{id}",method = RequestMethod.GET)
    public String say4(@PathVariable("id") Integer myid){
        return myid+"以上是say4输出";
    }

    @RequestMapping(value = "/{tid}/say5",method = RequestMethod.GET)
    public String say5(@PathVariable("tid") Integer parm){
        return parm+"以上是say5输出";
    }

    @RequestMapping(value = "/say6",method = RequestMethod.GET)
    public String say6(@RequestParam("ffid") Integer fid){
        return fid+"以上是say6输出";
    }

    @RequestMapping(value = "/say7",method = RequestMethod.GET)
    public String say7(@RequestParam(value = "eeid",required = false,defaultValue = "0") Integer eid){
        return eid+"以上是say7输出";
    }
}
