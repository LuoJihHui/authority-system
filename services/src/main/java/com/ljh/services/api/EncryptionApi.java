package com.ljh.services.api;

import com.ljh.services.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 加密相关Api
 *
 * @author luojiahui
 * @date 2020/6/15 10:22
 * @description
 */
@RestController
@RequestMapping("/encryption")
public class EncryptionApi {

    @Autowired
    private EncryptionService encryptionService;

    /**
     * 获取前后端加密公钥
     *
     * @param username 用户名
     * @return
     */
    @GetMapping("/rsa/key")
    public Map<String, String> getRsaPublicKey(@RequestParam("user_name") String username) {
        return encryptionService.getRsaPublicKey(username);
    }
}
