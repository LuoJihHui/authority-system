package com.ljh.services.entity;

import java.io.Serializable;

/**
 * (AsOrganizationT)实体类
 *
 * @author makejava
 * @since 2020-06-12 15:15:23
 */
public class AsOrganizationT implements Serializable {
    private static final long serialVersionUID = -25112062069397218L;
    
    private String id;
    /**
    * 父组织id
    */
    private String parentOrgId;
    /**
    * 组织名称
    */
    private String orgName;
    /**
    * 组织级别
    */
    private Integer orgLevel;
    /**
    * 组织属性
    */
    private String orgAttribute;
    /**
    * 排序
    */
    private Integer sort;
    /**
    * 描述
    */
    private String descibe;
    /**
    * 是否禁用(1禁用/0可用)
    */
    private Integer disable;

    @Override
    public String toString() {
        return "AsOrganizationT{" +
                "id='" + id + '\'' +
                ", parentOrgId='" + parentOrgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", orgLevel=" + orgLevel +
                ", orgAttribute='" + orgAttribute + '\'' +
                ", sort=" + sort +
                ", descibe='" + descibe + '\'' +
                ", disable=" + disable +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(Integer orgLevel) {
        this.orgLevel = orgLevel;
    }

    public String getOrgAttribute() {
        return orgAttribute;
    }

    public void setOrgAttribute(String orgAttribute) {
        this.orgAttribute = orgAttribute;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDescibe() {
        return descibe;
    }

    public void setDescibe(String descibe) {
        this.descibe = descibe;
    }

    public Integer getDisable() {
        return disable;
    }

    public void setDisable(Integer disable) {
        this.disable = disable;
    }

}