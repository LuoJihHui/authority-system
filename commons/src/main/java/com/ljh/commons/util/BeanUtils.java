package com.ljh.commons.util;

import cn.hutool.core.bean.copier.CopyOptions;

/**
 * Bean注入工具类
 *
 * @author luojiahui
 * @date 2020/6/12 16:37
 * @description
 */
public class BeanUtils {

    private BeanUtils() {
    }

    /**
     * 设置忽略注入错误
     */
    public static CopyOptions setCopyOptions() {
        CopyOptions copyOptions = new CopyOptions();
        copyOptions.ignoreCase();
        copyOptions.ignoreError();
        return copyOptions;
    }
}
