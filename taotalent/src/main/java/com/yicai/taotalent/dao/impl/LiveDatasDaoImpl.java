package com.yicai.taotalent.dao.impl;

import com.yicai.taotalent.dao.LiveDatasDao;
import com.yicai.taotalent.domain.Livedatas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by RamboLi
 * Date 2018/5/8 0008
 * Time 13:46
 */
@Component
public class LiveDatasDaoImpl implements LiveDatasDao {
    private final static Logger logger = LoggerFactory.getLogger(LiveDatasDaoImpl.class);
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<Livedatas> getLiveDatasAnchorList(Integer page,Integer pageSize){
       Integer startRows = (page - 1) * pageSize;
       Aggregation aggregation = Aggregation.newAggregation(
           Livedatas.class,
           Aggregation.lookup("anchors","accountId","userId","anchorslist"),
           Aggregation.sort(new Sort(new Sort.Order(Sort.Direction.DESC, "created"))),
           Aggregation.skip(startRows),
           Aggregation.limit(pageSize)
       );
//        List<Anchors> anchorsList = tradeRepository.findAggregateList(new Query(criteria), userId, customerAgg,CustomerDetail.class);
//        return anchorsList;
//.lookup("anchors","userId","accountId","anchorlivedata");
//        AggregationResults<Cat1UpdateCount> results = mongoTemplate.aggregate(agg, Video.COLLECTION_NAME, Cat1UpdateCount.class);
//        List<Cat1UpdateCount> cat1UpdateCountList = results.getMappedResults();
       AggregationResults<Livedatas> results = mongoTemplate.aggregate(aggregation, Livedatas.class, Livedatas.class);
       List<Livedatas> livedatasAnchorList = results.getMappedResults();
       logger.info("livedatasList size========================"+livedatasAnchorList.size());
       return livedatasAnchorList;
    }

    public List<Livedatas> getLiveDatasLiveList(Integer page,Integer pageSize){
        Integer startRows = (page - 1) * pageSize;
        Aggregation aggregation = Aggregation.newAggregation(
                Livedatas.class,
                Aggregation.lookup("live2","liveId","liveId","live2list"),
                Aggregation.sort(new Sort(new Sort.Order(Sort.Direction.DESC, "created"))),
                Aggregation.skip(startRows),
                Aggregation.limit(pageSize)
        );
        AggregationResults<Livedatas> results = mongoTemplate.aggregate(aggregation, Livedatas.class, Livedatas.class);
        List<Livedatas> livedatasLiveList = results.getMappedResults();
        logger.info("livedatasList size========================"+livedatasLiveList.size());
        return livedatasLiveList;
    }
}
