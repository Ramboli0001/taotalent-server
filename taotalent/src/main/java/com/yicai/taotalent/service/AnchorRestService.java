package com.yicai.taotalent.service;

import com.yicai.taotalent.domain.Anchors;
import com.yicai.taotalent.domain.Result;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by RamboLi
 * Date 2018/5/4 0004
 * Time 21:49
 */
@RequestMapping(value = "/anchorsty")
public interface AnchorRestService {
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    List<Anchors> getUserList();

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Result<Anchors> postAnchor(@Valid Anchors anchors, BindingResult bindingResult) throws Exception;

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    Anchors getUser(@PathVariable Long id);
//
//    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
//    String putUser(@PathVariable Long id, @ModelAttribute Anchors user);
//
//    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
//    String deleteUser(@PathVariable Long id);
}
