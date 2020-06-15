package com.ljh.services.service;

import java.util.Map;

/**
 * @author luojiahui
 * @date 2020/6/12 16:33
 * @description
 */
public interface UserService {

    /**
     * 用户登录并签发token
     *
     * @param name
     * @param pwd
     * @return
     */
    Map<String, Object> login(String name, String pwd);

    /**
     * 创建新用户
     *
     * @param param
     * @return
     */
    Boolean addUser(Map<String, Object> param);
}
