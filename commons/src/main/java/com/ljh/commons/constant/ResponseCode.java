package com.ljh.commons.constant;

/**
 * Description :返回格式
 *
 * @author cisdi
 * @date 2019/9/11 16:01
 */
public enum ResponseCode {
    /**
     * 调用成功
     */
    SUCCESS("0", "success"),

    /**
     * 系统错误
     */
    ERROR("-1", "failed"),

    /**
     * 用户未认证
     */
    UNAUTHORIZED("401", "Unauthorized"),

    /**
     * ACCESS_TOKEN过期
     */
    EXPIRED_ACCESS_TOKEN("40510", "access_token不合法或已过期"),

    /**
     * 服务未连接至eureka
     */
    UNCONNECTED("40511", "RemoteCallFailed"),

    /**
     * 用户管理更新失败
     */
    ORGANIZATION_ERROR("40512", "organization_error"),

    /*------------- START文件错误码 ------------- */
    /**
     * FILE_CHECK_ERROR 文件校验错误
     */
    FILE_CHECK_ERROR("500101", "文件校验错误"),

    /**
     * FILE_TOO_LARGE_ERROR 文件过大
     */
    FILE_TOO_LARGE_ERROR("500102", "文件格式错误"),

    /**
     * FILE_TOO_LARGE_ERROR 文件过大
     */
    FILE_TYPE_ERROR("500103", "文件格式错误"),

    /**
     * NOT_VALID_ERROR 参数校验异常
     */
    NOT_VALID_ERROR("500104", "参数校验异常"),

    /*------------- END文件错误码 ------------- */

    /*--------  START 数字重庆接口错误码   ------------*/

    DIGITAL_CQ_API_ERROR("500105", "第三方接口返回数据格式不正确"),


    /*--------  END 数字重庆接口错误码   ------------*/

    DATA_EXISTS_ERROR("500106", "当前数据已存在"),

    FILE_SIZE_TO_LARGE("500107", "文件太大,无法上传"),

    PARAM_VALIDATE_ERROR("500108","参数检验错误"),

    /*--------  START 订单接口错误码 500200~500299  ------------*/

    BILL_CHARGE_UNIT_ERROR("500200", "订单计费错误"),

    BILL_CHARGE_UNIT_PRICE_ERROR("500201", "订单计费价格错误");

    /*--------  END 订单接口错误码   ------------*/
    /**
     * 返回码
     */
    private final String code;

    /**
     * 返回信息
     */
    private final String msg;

    /**
     * 设置枚举值
     *
     * @param code
     * @param msg
     */
    ResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取返回码
     *
     * @return
     */
    public String getCode() {
        return this.code;
    }

    /**
     * 获取返回信息
     *
     * @return
     */
    public String getMsg() {
        return this.msg;
    }

}
