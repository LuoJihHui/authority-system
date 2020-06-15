package com.ljh.services.entity;

import java.io.Serializable;

/**
 * (AsRoleModuleR)实体类
 *
 * @author makejava
 * @since 2020-06-12 15:15:23
 */
public class AsRoleModuleR implements Serializable {
    private static final long serialVersionUID = 901152056543619735L;
    
    private String id;
    /**
    * 角色序号
    */
    private String roleId;
    /**
    * 模块序号
    */
    private String moduleId;

    @Override
    public String toString() {
        return "AsRoleModuleR{" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", moduleId='" + moduleId + '\'' +
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

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

}