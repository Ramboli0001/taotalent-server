package com.yicai.taotalent.service;

import com.yicai.taotalent.domain.Anchors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by RamboLi
 * Date 2018/5/4 0004
 * Time 21:27
 */
@RequestMapping(value = "/users")
public interface UserRestService {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Anchors> getUserList();

    @RequestMapping(value = "/", method = RequestMethod.POST)
    String postUser(@ModelAttribute Anchors user);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Anchors getUser(@PathVariable Long id);

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    String putUser(@PathVariable Long id, @ModelAttribute Anchors user);

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    String deleteUser(@PathVariable Long id);
}