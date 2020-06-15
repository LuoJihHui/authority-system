package com.ljh.services.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ljh.commons.util.BeanUtils;
import com.ljh.services.entity.AsUserT;
import com.ljh.services.mapper.AsUserMapper;
import com.ljh.services.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
