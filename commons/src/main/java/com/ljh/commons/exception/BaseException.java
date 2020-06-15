package com.ljh.commons.exception;

/**
 * 基础异常
 *
 * @author luojiahui
 * @date 2020/6/15 9:35
 * @description
 */
public class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }
}
