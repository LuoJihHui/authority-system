package com.ljh.services.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljh.commons.exception.BaseException;
import com.ljh.commons.util.AuthJwtHelper;
import com.ljh.commons.util.BeanUtils;
import com.ljh.services.entity.AsUserT;
import com.ljh.services.mapper.AsUserMapper;
import com.ljh.services.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luojiahui
 * @date 2020/6/12 16:34
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private AsUserMapper userMapper;

    /**
     * 用户登录并签发token
     *
     * @param name
     * @param pwd
     * @return
     */
    @Override
    public Map<String, Object> login(String name, String pwd) {
        QueryWrapper<AsUserT> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", name).eq("password", pwd);
        AsUserT user = userMapper.selectOne(wrapper);
        if (BeanUtil.isEmpty(user)) {
            throw new BaseException("未查询到用户信息,请检查密码或联系管理员！");
        }
        Map<String, Object> map = BeanUtil.beanToMap(user);
        Map<String, String> userMap = new HashMap<>();
        map.forEach((key, value) -> {
            userMap.put(key, String.valueOf(value));
        });
        //  签发token
        String token = AuthJwtHelper.getAuthJwtHelper().genJwtToken(userMap);
        map.remove("password");
        map.remove("disable");
        return new HashMap<String, Object>(2) {{
            put("user", map);
            put("token", token);
        }};
    }

    /**
     * 创建新用户
     *
     * @param param
     * @return
     */
    @Override
    public Boolean addUser(Map<String, Object> param) {
        AsUserT user = BeanUtil.mapToBean(param, AsUserT.class, BeanUtils.setCopyOptions());
        return userMapper.insert(user) > 0;
    }
}
