package com.ljh.services.entity;

import java.io.Serializable;

/**
 * (AsRoleT)实体类
 *
 * @author makejava
 * @since 2020-06-12 15:15:23
 */
public class AsRoleT implements Serializable {
    private static final long serialVersionUID = 616624901882975767L;
    
    private String id;
    /**
    * 角色名称
    */
    private String roleName;
    /**
    * 角色描述
    */
    private String describe;

    @Override
    public String toString() {
        return "AsRoleT{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

}