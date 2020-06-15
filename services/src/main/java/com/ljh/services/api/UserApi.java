package com.ljh.services.api;

import com.ljh.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 用户相关API
 *
 * @author luojiahui
 * @date 2020/6/12 16:29
 * @description
 */
@RestController
@RequestMapping("/user/relevance")
public class UserApi {

    @Autowired
    private UserService userService;

    /**
     * 创建新用户
     *
     * @param param
     * @return
     */
    @PostMapping("/user")
    public Boolean addUser(@RequestBody Map<String, Object> param) {
        return userService.addUser(param);
    }
}
