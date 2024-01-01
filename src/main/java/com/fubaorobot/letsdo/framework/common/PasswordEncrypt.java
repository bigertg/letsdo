package com.fubaorobot.letsdo.framework.common;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.util.Base64;

/**
 * @ClassName : PasswordEncrypt  //类名
 * @Description : 密码加密  //描述
 * @Author : zx  //作者
 * @Date: 2021-06-08 17:00  //时间
 */
@Slf4j
public class PasswordEncrypt {
    /**
     * @Author zx
     * @Description //TODO md5密码加密
     * @Date 17:00 2021/6/8
     * @Param
     * @return
     **/
    public static String encodeByMd5(String password)  {
        try {
            // 确定计算方法
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            Base64.Encoder base64Encoder = Base64.getEncoder();
            //加密字符串
            return base64Encoder.encodeToString(md5.digest(password.getBytes("utf-8")));
        } catch (Exception e) {
            log.error("MD5 Error...",e);
            throw new RuntimeException("MD5 error",e);
        }
    }
}
