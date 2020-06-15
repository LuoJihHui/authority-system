package com.ljh.services.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (AsUserT)实体类
 *
 * @author makejava
 * @since 2020-06-12 15:15:23
 */
@TableName("as_user_t")
public class AsUserT implements Serializable {

    @TableId(type = IdType.UUID)
    private String id;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 用户别名
    */
    private String userAliasName;
    /**
    * 密码
    */
    private String password;
    /**
    * 是否禁用(1禁用/0可用)
    */
    private Integer disable;
    /**
    * CA证书
    */
    private String caCertificate;
    /**
    * 排序
    */
    private Integer sort;
    /**
    * 描述
    */
    private String userDescribe;

    @Override
    public String toString() {
        return "AsUserT{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", userAliasName='" + userAliasName + '\'' +
                ", password='" + password + '\'' +
                ", disable=" + disable +
                ", caCertificate='" + caCertificate + '\'' +
                ", sort=" + sort +
                ", userDescribe='" + userDescribe + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAliasName() {
        return userAliasName;
    }

    public void setUserAliasName(String userAliasName) {
        this.userAliasName = userAliasName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDisable() {
        return disable;
    }

    public void setDisable(Integer disable) {
        this.disable = disable;
    }

    public String getCaCertificate() {
        return caCertificate;
    }

    public void setCaCertificate(String caCertificate) {
        this.caCertificate = caCertificate;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUserDescribe() {
        return userDescribe;
    }

    public void setUserDescribe(String userDescribe) {
        this.userDescribe = userDescribe;
    }
}