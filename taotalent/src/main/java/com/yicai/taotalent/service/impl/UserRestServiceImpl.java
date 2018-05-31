package com.yicai.taotalent.service.impl;

import com.yicai.taotalent.domain.Anchors;
import com.yicai.taotalent.service.UserRestService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by RamboLi
 * Date 2018/5/4 0004
 * Time 21:27
 */
@RestController
public class UserRestServiceImpl implements UserRestService {

    static Map<Long, Anchors> users = Collections.synchronizedMap(new HashMap<Long, Anchors>());

    @Override
    public List<Anchors> getUserList() {
        List<Anchors> r = new ArrayList<Anchors>(users.values());
        return r;
    }

    @Override
    public String postUser(@ModelAttribute Anchors user) {
//        users.put(user.getId(), user);
        return "success";
    }

    @Override
    public Anchors getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @Override
    public String putUser(@PathVariable Long id, @ModelAttribute Anchors user) {
        Anchors u = users.get(id);
//        u.setName(user.getName());
//        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @Override
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}
