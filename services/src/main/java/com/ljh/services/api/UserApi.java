package com.ljh.services.api;

import com.ljh.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 用户登录并签发token
     *
     * @param param
     * @return
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, Object> param) {
        return userService.login(param);
    }

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
