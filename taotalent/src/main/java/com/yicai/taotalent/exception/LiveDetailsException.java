package com.yicai.taotalent.exception;

import com.yicai.taotalent.enums.ResultEnum;

/**
 * Created by RamboLi
 * Date 2018/5/5 0005
 * Time 22:57
 */
public class LiveDetailsException extends RuntimeException{
    private Integer code;

    public LiveDetailsException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
