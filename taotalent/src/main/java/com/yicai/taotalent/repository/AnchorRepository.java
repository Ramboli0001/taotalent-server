package com.yicai.taotalent.repository;

import com.yicai.taotalent.domain.Anchors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by RamboLi
 * Date 2018/5/3 0003
 * Time 11:34
 */
@Repository
public interface AnchorRepository extends MongoRepository<Anchors,String> {
    Anchors findOne(String id);

    Anchors getAnchorsByUserId(String userId);

    public Page<Anchors> findByType(String type, Pageable pageable);

//    @Query("'$or':[{'firstName':{'$regex':?0,'$options':'i'}},{'lastName':{'$regex':?0,'$options':'i'}}]")
//    List<Anchors> findByEmailOrFirstnameOrLastnameLike(String searchText);
//
//    findByLocationWithin(Box box)
//    {"location" : {"$within" : {"$box" : [ [x1, y1], x2, y2]}}}
//
//    db.livedatas.aggregate([{
//        $lookup:
//        {
//            from:"anchors",
//                    localField:"userId",
//                foreignField:"accountId",
//                as:"anchorandlivedata"
//        }
//    },
//    { $match : { liveNum : {$gt:200} } }
//])


}
