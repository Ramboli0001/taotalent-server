package com.yicai.taotalent.dao.impl;

import com.yicai.taotalent.dao.AnchorsDao;
import com.yicai.taotalent.domain.Anchors;
import com.yicai.taotalent.domain.Livedatas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

/**
 * Created by RamboLi
 * Date 2018/5/8 0008
 * Time 0:42
 */
@Component
public class AnchorsDaoImpl implements AnchorsDao {
    private final static Logger logger=LoggerFactory.getLogger(AnchorsDaoImpl.class);
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<Anchors> getAnchorsList(Integer page,Integer pageSize){
        logger.info("dao 查询--------------》");
        /**
         * db.videos.aggregate(
         [
         { $match: { "frags.isnew" : true } },
         { $unwind: "$frags" },
         { $match: { "frags.isnew" : true } },
         { $group: {
         _id: {cat1:"$cat1"},
         count: { $sum: 1 },
         publishdate2: { $max: "$publishdate"}
         }
         }

         ]
         )
         */
        /**
         *

        db.livedatas.aggregate(
         [
         {
                $lookup:
        {
            from:"anchors",
                    localField:"userId",
                foreignField:"accountId",
                as:"anchorandlivedata"
        }
  },
        { $match : { liveNum : {$gt:200} } }
])  */
//        Integer pageSize = 10;
        Integer startRows = (page - 1) * pageSize;
//        Aggregation agg = new Aggregation(
//                project("frags","cat1","publishdate"),
//                match(
//                        Criteria.where("frags.isnew").is(Boolean.TRUE)
//                                .and("cat1").in(importantCat1List)
//                ),
//                unwind("frags"),//展开子项LIST，且是内链接，即如果父和子的关联ID没有的就不会输出
//                match(Criteria.where("frags.isnew").is(Boolean.TRUE)),
//                group("cat1")//设置分组字段
//                        .count().as("updateCount")//增加COUNT为分组字段
//                        .last("publishdate").as("publishDate"),//增加publishDate为分组字段
//                project("publishDate","cat1","updateCount")//重新挑选字段
//                        .and("cat1").previousOperation()//为前一操作所产生的ID FIELD建立别名
//        );
        Aggregation aggregation = Aggregation.newAggregation(
                Livedatas.class,
                Aggregation.lookup("anchors","userId","accountId","anchorlivedata"),
                Aggregation.sort(new Sort(new Sort.Order(Sort.Direction.DESC, "created"))),
                Aggregation.skip(startRows),
                Aggregation.limit(pageSize)
        );
//        List<Anchors> anchorsList = tradeRepository.findAggregateList(new Query(criteria), userId, customerAgg,CustomerDetail.class);
//        return anchorsList;
//.lookup("anchors","userId","accountId","anchorlivedata");
//        AggregationResults<Cat1UpdateCount> results = mongoTemplate.aggregate(agg, Video.COLLECTION_NAME, Cat1UpdateCount.class);
//        List<Cat1UpdateCount> cat1UpdateCountList = results.getMappedResults();
        AggregationResults<Anchors> results = mongoTemplate.aggregate(aggregation, Anchors.class, Anchors.class);
        List<Anchors> anchorsList = results.getMappedResults();
        logger.info("size========================"+anchorsList.size());
        return anchorsList;
    }

}
