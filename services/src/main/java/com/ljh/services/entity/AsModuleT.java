package com.ljh.services.entity;

import java.io.Serializable;

/**
 * (AsModuleT)实体类
 *
 * @author makejava
 * @since 2020-06-12 15:15:23
 */
public class AsModuleT implements Serializable {
    private static final long serialVersionUID = 985226789326662149L;
    
    private String id;
    /**
    * 父模块序号
    */
    private String parentModuleId;
    /**
    * 模块名称
    */
    private String moduleName;
    /**
    * 模块图片
    */
    private String modulePicture;
    /**
    * 模块跳转页面
    */
    private String moduleJumpPage;
    /**
    * 模块跳转框架
    */
    private String moduleJumpFrame;
    /**
    * 模块小图标
    */
    private String moduleIcon;
    /**
    * 是否默认显示(1显示/0不显示）
    */
    private Integer display;
    /**
    * 模块等级
    */
    private Integer moduleLevel;
    /**
    * 模块类别(权限属性)
    */
    private String moduleCategory;
    /**
    * 排序
    */
    private Integer sort;
    /**
    * 所属系统
    */
    private String systemId;
    /**
    * 描述
    */
    private String describe;

    @Override
    public String toString() {
        return "AsModuleT{" +
                "id='" + id + '\'' +
                ", parentModuleId='" + parentModuleId + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", modulePicture='" + modulePicture + '\'' +
                ", moduleJumpPage='" + moduleJumpPage + '\'' +
                ", moduleJumpFrame='" + moduleJumpFrame + '\'' +
                ", moduleIcon='" + moduleIcon + '\'' +
                ", display=" + display +
                ", moduleLevel=" + moduleLevel +
                ", moduleCategory='" + moduleCategory + '\'' +
                ", sort=" + sort +
                ", systemId='" + systemId + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentModuleId() {
        return parentModuleId;
    }

    public void setParentModuleId(String parentModuleId) {
        this.parentModuleId = parentModuleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModulePicture() {
        return modulePicture;
    }

    public void setModulePicture(String modulePicture) {
        this.modulePicture = modulePicture;
    }

    public String getModuleJumpPage() {
        return moduleJumpPage;
    }

    public void setModuleJumpPage(String moduleJumpPage) {
        this.moduleJumpPage = moduleJumpPage;
    }

    public String getModuleJumpFrame() {
        return moduleJumpFrame;
    }

    public void setModuleJumpFrame(String moduleJumpFrame) {
        this.moduleJumpFrame = moduleJumpFrame;
    }

    public String getModuleIcon() {
        return moduleIcon;
    }

    public void setModuleIcon(String moduleIcon) {
        this.moduleIcon = moduleIcon;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Integer getModuleLevel() {
        return moduleLevel;
    }

    public void setModuleLevel(Integer moduleLevel) {
        this.moduleLevel = moduleLevel;
    }

    public String getModuleCategory() {
        return moduleCategory;
    }

    public void setModuleCategory(String moduleCategory) {
        this.moduleCategory = moduleCategory;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

}