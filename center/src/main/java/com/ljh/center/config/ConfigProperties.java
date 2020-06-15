package com.ljh.center.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Center配置
 *
 * @author luojiahui
 * @date 2020/6/15 8:29
 * @description
 */
@Component
public class ConfigProperties {

    /**
     * 请求放行地址列表
     */
    @Value("${center.releaseAddress}")
    private String[] releaseUrlList;

    /**
     * 通用请求头token名称
     */
    @Value("${center.jwt.key}")
    private String tokenKey;

    public String getTokenKey() {
        return tokenKey;
    }

    public String[] getReleaseUrlList() {
        return releaseUrlList;
    }
}
