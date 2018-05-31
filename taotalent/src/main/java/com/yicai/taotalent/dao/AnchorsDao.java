package com.yicai.taotalent.dao;

import com.yicai.taotalent.domain.Anchors;

import java.util.List;

/**
 * Created by RamboLi
 * Date 2018/5/8 0008
 * Time 0:41
 */
public interface AnchorsDao {
    List<Anchors> getAnchorsList(Integer page,Integer pageSize);
}
