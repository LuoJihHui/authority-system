package com.ljh.services.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ljh.commons.exception.NonAccessTokenException;
import com.ljh.commons.util.AuthJwtHelper;
import com.ljh.commons.util.RsaUtils;
import com.ljh.services.entity.AsKeyT;
import com.ljh.services.mapper.AsKeyMapper;
import com.ljh.services.service.EncryptionService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luojiahui
 * @date 2020/6/15 10:26
 * @description
 */
@Service
public class EncryptionServiceImpl implements EncryptionService {

    @Resource
    private AsKeyMapper asKeyMapper;

    /**
     * 获取前后端加密公钥
     * 1.获取rsa秘钥对,存储在后端
     * 2.返回公钥
     *
     * @param token
     * @return
     */
    @Override
    public Map<String, String> getRsaPublicKey(String token) {
        String userId = AuthJwtHelper.getAuthJwtHelper().getUserIdFromJwtToken(token);
        if (StrUtil.isBlank(userId)) {
            throw new NonAccessTokenException("未获取到用户id,请检查当前用户是否有效登录!");
        }
        try {
            Map<String, Object> map = RsaUtils.genKeyPair();
            String publicKey = RsaUtils.getPublicKey(map);
            String privateKey = RsaUtils.getPrivateKey(map);
            insertKey(publicKey, privateKey, userId);
            return new HashMap<String, String>(1) {{
                put("publicKey", publicKey);
            }};
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 存储公私钥+用户id
     *
     * @param publicKey
     * @param privateKey
     * @param userId
     */
    @Async
    void insertKey(String publicKey, String privateKey, String userId) {
        QueryWrapper<AsKeyT> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        List<AsKeyT> keyList = asKeyMapper.selectList(wrapper);
        if (CollUtil.isEmpty(keyList)) {
            AsKeyT keyT = new AsKeyT();
            keyT.setRsaPrivateKey(privateKey);
            keyT.setRsaPublicKey(publicKey);
            keyT.setUserId(userId);
            asKeyMapper.insert(keyT);
        } else {
            UpdateWrapper<AsKeyT> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("user_id", userId).set("rsa_public_key", publicKey).set("rsa_private_key", privateKey);
            asKeyMapper.update(null, updateWrapper);
        }
    }
}
