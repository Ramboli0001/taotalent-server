package com.yicai.taotalent.repository;

import com.yicai.taotalent.domain.Livedatas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by RamboLi
 * Date 2018/5/6 0006
 * Time 23:46
 */
public interface LiveDatasRepository extends MongoRepository<Livedatas,String>{
    public Page<Livedatas> findByLiveId(String liveId, Pageable pageable);
}
