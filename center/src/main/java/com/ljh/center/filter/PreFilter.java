package com.ljh.center.filter;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.ljh.center.config.ConfigProperties;
import com.ljh.commons.util.AuthJwtHelper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Stream;

/**
 * 前置拦截器
 *
 * @author luojiahui
 * @date 2020/6/15 8:23
 * @description
 */
@Component
public class PreFilter extends ZuulFilter {

    @Autowired
    private ConfigProperties properties;

    private static final Logger logger = LoggerFactory.getLogger(PreFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String path = request.getRequestURL().toString();
        // 放行地址列表
        String[] releaseUrlList = properties.getReleaseUrlList();
        Stream.of(releaseUrlList).forEach(url -> {
            if (!path.contains(url)) {
                // 校验token
                String token = Convert.toStr(request.getHeader(properties.getTokenKey()));
                // token为空或检验未通过
                if (StrUtil.isBlank(token) || !AuthJwtHelper.getAuthJwtHelper().verifyJwtToken(token)) {
                    logger.warn("Authorization token expired or incorrect");
                    outInfo(context);
                }
                logger.info("Authorization token is ok");
            }
        });
        return null;
    }

    /**
     * 统一输出信息
     *
     * @param requestContext
     */
    private void outInfo(RequestContext requestContext) {
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(401);
        requestContext.setResponseBody("Authorization token expired or incorrect");
    }
}
