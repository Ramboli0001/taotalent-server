package com.yicai.taotalent.handle;

import com.yicai.taotalent.domain.Result;
import com.yicai.taotalent.exception.AnchorsException;
import com.yicai.taotalent.exception.GirlException;
import com.yicai.taotalent.exception.Live2Exception;
import com.yicai.taotalent.exception.LiveDetailsException;
import com.yicai.taotalent.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by RamboLi
 * Date 2018/4/23 0023
 * Time 14:54
 */
@ControllerAdvice
public class ExceptionHandle {
    private static final Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException=(GirlException)e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else if(e instanceof AnchorsException){
            AnchorsException anchorsException=(AnchorsException)e;
            return ResultUtil.error(anchorsException.getCode(),anchorsException.getMessage());
        }else if(e instanceof Live2Exception){
            Live2Exception live2Exception=(Live2Exception)e;
            return ResultUtil.error(live2Exception.getCode(),live2Exception.getMessage());
        }else if(e instanceof LiveDetailsException){
            LiveDetailsException liveDetailsException=(LiveDetailsException)e;
            return ResultUtil.error(liveDetailsException.getCode(),liveDetailsException.getMessage());
        }else{
            logger.error("【系统异常】{}",e);
            return ResultUtil.error(-1,"未知错误！！");
        }

    }
}
