package com.yicai.taotalent.dao;

import com.yicai.taotalent.domain.Livedatas;

import java.util.List;

/**
 * Created by RamboLi
 * Date 2018/5/8 0008
 * Time 12:17
 */
public interface LiveDatasDao {

   List<Livedatas> getLiveDatasAnchorList(Integer page,Integer pageSize);

   List<Livedatas> getLiveDatasLiveList(Integer page,Integer pageSize);
}
