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

    @Value("${center.releaseAddress}")
    private String[] releaseUrlList;

    public String[] getReleaseUrlList() {
        return releaseUrlList;
    }
}
