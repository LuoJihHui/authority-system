package com.ljh.services.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (AsKeyT)实体类
 *
 * @author makejava
 * @since 2020-06-15 10:33:16
 */
@TableName("as_key_t")
public class AsKeyT implements Serializable {
    @TableId(type = IdType.UUID)
    private String id;
    /**
     * rsa公钥
     */
    private String rsaPublicKey;
    /**
     * rsa私钥
     */
    private String rsaPrivateKey;
    /**
     * sm4加密秘钥
     */
    private String sm4Key;
    /**
     * 用户id
     */
    private String userId;

    @Override
    public String toString() {
        return "AsKeyT{" +
                "id='" + id + '\'' +
                ", rsaPublicKey='" + rsaPublicKey + '\'' +
                ", rsaPrivateKey='" + rsaPrivateKey + '\'' +
                ", sm4Key='" + sm4Key + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRsaPublicKey() {
        return rsaPublicKey;
    }

    public void setRsaPublicKey(String rsaPublicKey) {
        this.rsaPublicKey = rsaPublicKey;
    }

    public String getRsaPrivateKey() {
        return rsaPrivateKey;
    }

    public void setRsaPrivateKey(String rsaPrivateKey) {
        this.rsaPrivateKey = rsaPrivateKey;
    }

    public String getSm4Key() {
        return sm4Key;
    }

    public void setSm4Key(String sm4Key) {
        this.sm4Key = sm4Key;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}