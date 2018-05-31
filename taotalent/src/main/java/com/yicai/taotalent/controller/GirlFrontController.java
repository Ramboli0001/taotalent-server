package com.yicai.taotalent.controller;

import com.yicai.taotalent.domain.Girl;
import com.yicai.taotalent.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by RamboLi
 * Date 2018/4/26 0026
 * Time 18:29
 */
@Controller
@RequestMapping(value = "/getgirl")
public class GirlFrontController {
    @Autowired
    private GirlService girlService;
    @RequestMapping(value = "/girllist/{id}",method = RequestMethod.GET)
    public String getGirlList(@PathVariable("id") Integer girlid,Model model){
        Girl girl = girlService.findOne(girlid);
        model.addAttribute("girl",girl);
        return "girllist";
    }
}
