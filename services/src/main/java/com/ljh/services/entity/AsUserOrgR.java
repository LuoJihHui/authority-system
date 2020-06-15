package com.ljh.services.entity;

import java.io.Serializable;

/**
 * (AsUserOrgR)实体类
 *
 * @author makejava
 * @since 2020-06-12 15:15:23
 */
public class AsUserOrgR implements Serializable {
    private static final long serialVersionUID = 867656736909188927L;
    
    private String id;
    /**
    * 用户序号
    */
    private String userId;
    /**
    * 组织序号
    */
    private String orgId;
    /**
    * 是否为组织负责人
    */
    private Integer isPrincipal;

    @Override
    public String toString() {
        return "AsUserOrgR{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", orgId='" + orgId + '\'' +
                ", isPrincipal=" + isPrincipal +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Integer getIsPrincipal() {
        return isPrincipal;
    }

    public void setIsPrincipal(Integer isPrincipal) {
        this.isPrincipal = isPrincipal;
    }

}