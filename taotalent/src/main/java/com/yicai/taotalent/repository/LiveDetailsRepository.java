package com.yicai.taotalent.repository;

import com.yicai.taotalent.domain.Livedetails;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by RamboLi
 * Date 2018/5/5 0005
 * Time 22:54
 */
public interface LiveDetailsRepository extends MongoRepository<Livedetails,String> {
}
