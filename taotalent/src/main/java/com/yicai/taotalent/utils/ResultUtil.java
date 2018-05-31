package com.yicai.taotalent.utils;

import com.yicai.taotalent.domain.Result;

/**
 * Created by RamboLi
 * Date 2018/4/23 0023
 * Time 11:10
 */
public class ResultUtil {
    public static Result success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }
    public static Result success(){
        return success(null);
    }
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
