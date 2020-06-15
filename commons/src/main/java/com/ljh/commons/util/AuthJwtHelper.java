package com.ljh.commons.util;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.ljh.commons.constant.SystemConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luojiahui
 * @date 2020/6/15 9:00
 * @description
 */
public class AuthJwtHelper {

    private static final Logger logger = LoggerFactory.getLogger(AuthJwtHelper.class);

    private AuthJwtHelper() {
    }

    private static final AuthJwtHelper JWT_HELPER = new AuthJwtHelper();

    public static AuthJwtHelper getAuthJwtHelper() {
        return JWT_HELPER;
    }

    private static Algorithm algorithm = null;
    /**
     * 默认过期时间
     */
    private static final int DEFAULT_EXPIRE = 7200;
    /**
     * token动态到期时间点（该时间点一般是系统访问量最低的时候，默认晚上11:30）
     */
    private static final LocalTime EXPIRE_TIME = LocalTime.of(23, 59);

    /**
     * 生成JWT token
     * 使用HMAC-SHA256算法进行token签名
     *
     * @param userId token中只添加personId信息
     * @return
     */
    public String genJwtToken(String userId) {
        return JwtHelper.getJwtHelper().genJwtToken(getAlgorithm(), getExpireAt(),
                Collections.singletonMap(SystemConstant.JWT_USER_ID, userId));
    }

    /**
     * 生成JWT token
     * 使用HMAC-SHA256算法进行token签名
     *
     * @param claims token中添加一组信息
     * @return
     */
    public String genJwtToken(Map<String, String> claims) {
        return JwtHelper.getJwtHelper().genJwtToken(getAlgorithm(), getExpireAt(), claims);
    }

    /**
     * 验证token是否合法，包括token是否被篡改，是否到期
     *
     * @param token
     * @return 合法：true； 非法：false
     */
    public Boolean verifyJwtToken(String token) {
        try {
            JwtHelper.getJwtHelper().verifyJWTToken(getAlgorithm(), token);
        } catch (JWTVerificationException ex) {
            logger.error(ex.getMessage());
            throw new JWTVerificationException("access_token不合法或已过期");
        }
        return true;
    }

    /**
     * 从Jwt中获取用户ID, 当前只会在token里面添加personId这一个用户标识
     *
     * @param token
     * @return
     */
    public String getUserIdFromJwtToken(String token) {
        if (verifyJwtToken(token)) {
            return JwtHelper.getJwtHelper().getPayloadFromJWT(token).get(SystemConstant.JWT_USER_ID).asString();
        }
        return null;
    }

    /**
     * 从Jwt中获取用户详细信息, 当前会在token里面添加用户所有信息标识
     *
     * @param token
     * @return
     */
    public Map<String, Object> getUserInfoFromJwtToken(String token) {
        Map<String, Object> result = new HashMap<>();
        if (verifyJwtToken(token)) {
            Map<String, Claim> claims = JwtHelper.getJwtHelper().getPayloadFromJWT(token);
            claims.forEach((key, value) -> {
                result.put(key, value.asString());
            });
            return result;
        }
        return null;
    }

    /**
     * 动态计算token的到期时间
     *
     * @param
     * @return
     */
    private static long getExpireAt() {
        //如果当前时间与EXPIRE_TIME之间相差大于2个小时，则使用动态的时间（晚上11：30到期）
        long duration = ChronoUnit.SECONDS.between(LocalTime.now(), EXPIRE_TIME);
        return duration > DEFAULT_EXPIRE ? duration : DEFAULT_EXPIRE;
    }

    private static Algorithm getAlgorithm() {
        if (algorithm == null) {
            algorithm = SecretHelper.getHSAlg(SecretHelper.getShSecret());
        }
        return algorithm;
    }
}
