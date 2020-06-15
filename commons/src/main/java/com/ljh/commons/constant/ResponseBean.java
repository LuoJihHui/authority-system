package com.ljh.commons.constant;

import java.util.Map;

/**
 * Description :返回参数实体类
 *
 * @author : zhang
 * @date : 2019/9/11 16:00
 */
public class ResponseBean {
    /**
     * 返回码
     */
    private String code = "0";
    /**
     * 返回说明
     */
    private String msg = "success";
    /**
     * 业务数据
     */
    private Object data;

    /**
     * 获取返回码
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置返回码
     *
     * @return
     */
    public ResponseBean setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * 获取返回信息
     *
     * @return
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置返回信息
     *
     * @param msg
     * @return
     */
    public ResponseBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    /**
     * 获取数据
     *
     * @return
     */
    public Object getData() {
        return data;
    }

    /**
     * 设置数据
     *
     * @param data
     * @return
     */
    public ResponseBean setData(Object data) {
        this.data = data;
        return this;
    }

    /**
     * 设置返回状态
     *
     * @param responseCode
     * @return
     */
    public ResponseBean setResponseCode(ResponseCode responseCode) {
        this.setCode(responseCode.getCode());
        this.setMsg(responseCode.getMsg());
        return this;
    }

    /**
     * 设置ResponseBean对象属性
     *
     * @param parameterMap 设置参数
     * @return
     */
    public ResponseBean setResponse(Map<String, Object> parameterMap) {
        for (String key : parameterMap.keySet()) {
            if ("code".equals(key)) {
                this.setCode(String.valueOf(parameterMap.get(key)));
            } else if ("msg".equals(key)) {
                this.setMsg((String) parameterMap.get(key));
            } else if ("code".equals(key) || "msg".equals(key)) {
                this.setCode(null);
                this.setMsg(null);
            }
        }
        this.setData(parameterMap.get("data"));
        return this;
    }

    public ResponseBean(Object data) {
        this.data = data;
    }

    public ResponseBean(){ }
}
