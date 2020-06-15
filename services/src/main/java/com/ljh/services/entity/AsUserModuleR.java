package com.ljh.services.entity;

import java.io.Serializable;

/**
 * (AsUserModuleR)实体类
 *
 * @author makejava
 * @since 2020-06-12 15:15:23
 */
public class AsUserModuleR implements Serializable {
    private static final long serialVersionUID = -19487241163211186L;
    
    private String id;
    /**
    * 组织序号
    */
    private String orgId;
    /**
    * 用户序号
    */
    private String userId;
    /**
    * 模块序号
    */
    private String moduleId;
    /**
    * 标识
    */
    private Integer disable;

    @Override
    public String toString() {
        return "AsUserModuleR{" +
                "id='" + id + '\'' +
                ", orgId='" + orgId + '\'' +
                ", userId='" + userId + '\'' +
                ", moduleId='" + moduleId + '\'' +
                ", disable=" + disable +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getDisable() {
        return disable;
    }

    public void setDisable(Integer disable) {
        this.disable = disable;
    }

}