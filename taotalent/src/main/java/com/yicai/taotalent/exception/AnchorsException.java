package com.yicai.taotalent.exception;

import com.yicai.taotalent.enums.ResultEnum;

/**
 * Created by RamboLi
 * Date 2018/5/3 0003
 * Time 16:12
 */
public class AnchorsException extends RuntimeException{
    private Integer code;

    public AnchorsException(ResultEnum resultEnum) {
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
