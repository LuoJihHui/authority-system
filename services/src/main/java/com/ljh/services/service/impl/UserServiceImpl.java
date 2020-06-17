package com.ljh.services.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljh.commons.exception.BaseException;
import com.ljh.commons.exception.PasswordErrorException;
import com.ljh.commons.util.AuthJwtHelper;
import com.ljh.commons.util.BeanUtils;
import com.ljh.commons.util.RsaUtils;
import com.ljh.services.entity.AsKeyT;
import com.ljh.services.entity.AsUserT;
import com.ljh.services.mapper.AsKeyMapper;
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
    @Resource
    private AsKeyMapper asKeyMapper;

    /**
     * 用户登录并签发token
     *
     * @param param
     * @return
     */
    @Override
    public Map<String, Object> login(Map<String, Object> param) {
        QueryWrapper<AsUserT> wrapper = new QueryWrapper<>();
        Object name = param.get("name");
        wrapper.eq("user_name", name).eq("disable", 0);
        AsUserT user = userMapper.selectOne(wrapper);
        if (BeanUtil.isEmpty(user)) {
            throw new BaseException("未查询到用户信息,请联系管理员！");
        }
        String publicKey = Convert.toStr(param.get("publicKey"));
        // 密文
        String password = Convert.toStr(param.get("password"));
        // rsa私钥解取明文
        String pwd = RsaUtils.decryptData(password, getPrivateKey(Convert.toStr(name), publicKey));
        // TODO:后期使用SM4加密数据库密码
        if (!user.getPassword().equals(pwd)) {
            throw new PasswordErrorException("密码错误!");
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

    /**
     * 根据用户名和公钥查询对应私钥
     *
     * @param name
     * @param publicKey
     * @return
     */
    private String getPrivateKey(String name, String publicKey) {
        QueryWrapper<AsKeyT> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", name).eq("rsa_public_key", publicKey);
        AsKeyT asKeyT = asKeyMapper.selectOne(queryWrapper);
        if (BeanUtil.isEmpty(asKeyT) || StrUtil.isBlank(Convert.toStr(asKeyT.getRsaPrivateKey()))) {
            throw new BaseException("未查询到当前用户名" + name + "秘钥信息!");
        }
        return asKeyT.getRsaPrivateKey();
    }
}
