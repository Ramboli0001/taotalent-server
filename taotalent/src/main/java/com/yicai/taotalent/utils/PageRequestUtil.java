package com.yicai.taotalent.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * Created by RamboLi
 * Date 2018/5/5 0005
 * Time 15:42
 */
public class PageRequestUtil {
    /**
     * 创建分页请求
     * @param pageNumber
     * @param pageSize
     * @param sortType
     * @return
     */
    public static PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType) {
        Sort sort = null;
//        if ("auto".equals(sortType)) {
//            sort = new Sort(Sort.Direction.DESC, "id");
//        } else if ("created".equals(sortType)) {
//            sort = new Sort(Sort.Direction.ASC, "created");
//        }
        sort = new Sort(Sort.Direction.DESC, sortType);
        //参数1表示当前第几页,参数2表示每页的大小,参数3表示排序
        return new PageRequest(pageNumber-1,pageSize,sort);
    }
}
