package com.ljh.commons.globalhandlers;

import com.ljh.commons.constant.ResponseBean;
import com.ljh.commons.constant.ResponseCode;
import com.ljh.commons.exception.BaseException;
import com.ljh.commons.exception.NonAccessTokenException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author luojiahui
 * @date 2020/6/15 9:32
 * @description
 */
@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandlers {

    /**
     * 处理基础异常
     *
     * @param exception 抛出的异常类型
     */
    @ExceptionHandler(BaseException.class)
    public ResponseBean handleValidationBodyException(BaseException exception) {
        exception.printStackTrace();
        ResponseBean responseBean = new ResponseBean();
        responseBean.setResponseCode(ResponseCode.ERROR);
        responseBean.setData(exception.getMessage());
        return responseBean;
    }

    /**
     * 处理基础异常
     *
     * @param exception 抛出的异常类型
     */
    @ExceptionHandler(NonAccessTokenException.class)
    public ResponseBean handleValidationBodyException(NonAccessTokenException exception) {
        exception.printStackTrace();
        ResponseBean responseBean = new ResponseBean();
        responseBean.setResponseCode(ResponseCode.UNAUTHORIZED);
        responseBean.setData(exception.getMessage());
        return responseBean;
    }
}
