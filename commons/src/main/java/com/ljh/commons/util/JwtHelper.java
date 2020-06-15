package com.ljh.commons.util;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;

/**
 * @author luojiahui
 * @date 2020/6/15 8:48
 * @description
 */
public class JwtHelper {

    private static final Logger logger = LoggerFactory.getLogger(JwtHelper.class);

    private static final String ISSUER = "LJH";

    private static JwtHelper jwtHelper = new JwtHelper();

    public static JwtHelper getJwtHelper() {
        return jwtHelper;
    }

    /**
     * 生成JWT token
     *
     * @param payload 需要添加到token中的payload信息
     * @return
     */
    public String genJwtToken(Algorithm alg, long expiresAt, Map<String, String> payload) {
        Date date = new Date();
        try {
            JWTCreator.Builder builder = JWT.create()
                    .withIssuer(ISSUER)
                    .withExpiresAt(DateUtil.offsetSecond(date, new Long(expiresAt).intValue()));

            payload.forEach(builder::withClaim);
            return builder.sign(alg);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }

    /**
     * 验证JWT token
     * 主要包括是否被篡改以及是否到期
     * 在到期前30秒内有效
     *
     * @param token
     * @return
     */
    public void verifyJWTToken(Algorithm alg, String token) {
        JWT.require(alg)
                .withIssuer(ISSUER)
                .build()
                .verify(token);
    }

    /**
     * 从JWT中获取
     *
     * @param token
     */
    public Map<String, Claim> getPayloadFromJWT(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaims();
        } catch (JWTDecodeException ex) {
            logger.error(ex.getMessage());
            throw ex;
        }
    }
}
