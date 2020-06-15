package com.ljh.services.entity;

import java.io.Serializable;

/**
 * (AsOrgModuleR)实体类
 *
 * @author makejava
 * @since 2020-06-12 15:15:23
 */
public class AsOrgModuleR implements Serializable {
    private static final long serialVersionUID = 657957983539322280L;
    
    private String id;
    /**
    * 组织序号
    */
    private String orgId;
    /**
    * 模块序号
    */
    private String moduleId;

    @Override
    public String toString() {
        return "AsOrgModuleR{" +
                "id='" + id + '\'' +
                ", orgId='" + orgId + '\'' +
                ", moduleId='" + moduleId + '\'' +
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

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

}