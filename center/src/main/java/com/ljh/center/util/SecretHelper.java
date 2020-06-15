package com.ljh.center.util;

import com.auth0.jwt.algorithms.Algorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author luojiahui
 * @date 2020/6/15 8:55
 * @description
 */
public class SecretHelper {

    private static final Logger logger = LoggerFactory.getLogger(SecretHelper.class);

    private SecretHelper() {
    }

    private static final String SH_SECRET = "LJH-AUTH_SYSTEM-2020";

    public static String getShSecret() {
        return SH_SECRET;
    }

    /**
     * 获取HMAC SHA256摘要算法
     *
     * @return
     */
    public static Algorithm getHSAlg(String secret) {
        try {
            return Algorithm.HMAC256(secret);
        } catch ( Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
