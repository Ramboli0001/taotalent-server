package com.yicai.taotalent.repository;

import com.yicai.taotalent.domain.Live2;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by RamboLi
 * Date 2018/5/3 0003
 * Time 23:15
 */
public interface Live2Repository extends MongoRepository<Live2,String> {
//    @Override
    Live2 findOne(String s);

    Live2 getLive2ByLiveId(String liveid);
}
