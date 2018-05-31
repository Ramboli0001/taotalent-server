package com.yicai.taotalent.repository;

import com.yicai.taotalent.domain.Girl;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by RamboLi
 * Date 2018/4/19 0019
 * Time 16:26
 */
public interface GirlRepository extends MongoRepository<Girl,Integer> {

    List<Girl> getGirlsByAge(Integer age);
}
