package com.ljh.services.entity;

import java.io.Serializable;

/**
 * (AsUserRoleR)实体类
 *
 * @author makejava
 * @since 2020-06-12 15:15:23
 */
public class AsUserRoleR implements Serializable {
    private static final long serialVersionUID = -24349474123913746L;
    
    private String id;
    /**
    * 角色序号
    */
    private String roleId;
    /**
    * 用户序号
    */
    private String userId;

    @Override
    public String toString() {
        return "AsUserRoleR{" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}