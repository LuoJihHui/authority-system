package com.ljh.services.service;

import java.util.Map;

/**
 * @author luojiahui
 * @date 2020/6/15 10:26
 * @description
 */
public interface EncryptionService {

    /**
     * 获取前后端加密公钥
     *
     * @param userId
     * @return
     */
    Map<String, String> getRsaPublicKey(String userId);
}
