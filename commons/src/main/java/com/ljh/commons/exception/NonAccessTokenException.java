package com.ljh.commons.exception;

/**
 * 自定义token异常
 *
 * @author luojiahui
 * @date 2020/6/15 10:45
 * @description
 */
public class NonAccessTokenException extends BaseException {

    public NonAccessTokenException(String message) {
        super(message);
    }
}
