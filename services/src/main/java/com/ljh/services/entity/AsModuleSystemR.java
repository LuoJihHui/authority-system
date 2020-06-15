package com.ljh.services.entity;

import java.io.Serializable;

/**
 * (AsModuleSystemR)实体类
 *
 * @author makejava
 * @since 2020-06-12 15:15:22
 */
public class AsModuleSystemR implements Serializable {
    private static final long serialVersionUID = 142276214577770166L;
    
    private String id;
    /**
    * 系统识别码
    */
    private String systemCode;
    /**
    * 系统名称
    */
    private String systemName;
    /**
    * 管理系统的超级管理员
    */
    private String systemAdmin;
    /**
    * 描述
    */
    private String describe;

    @Override
    public String toString() {
        return "AsModuleSystemR{" +
                "id='" + id + '\'' +
                ", systemCode='" + systemCode + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemAdmin='" + systemAdmin + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemAdmin() {
        return systemAdmin;
    }

    public void setSystemAdmin(String systemAdmin) {
        this.systemAdmin = systemAdmin;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

}