package com.fubaorobot.letsdo.framework.security.handler;/**
 * @author：tanghengqi
 * @date：2021-06-17 16:51
 * @description：<描述>
 */

import com.fubaorobot.letsdo.framework.common.PasswordEncrypt;
import com.fubaorobot.letsdo.framework.exception.BaseException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author：tanghengqi
 * @date：2021-06-17 16:51
 * @description：<描述>
 */
public class Md5PasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        if(null == charSequence) {
            throw new BaseException("加密字符不能为空");
        }
            return PasswordEncrypt.encodeByMd5(charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        if(null == charSequence || null == s) {
            return false;
        }
        return PasswordEncrypt.encodeByMd5(charSequence.toString()).equals(s);
    }

    @Override
    public boolean upgradeEncoding(String encodedPassword) {
        return PasswordEncoder.super.upgradeEncoding(encodedPassword);
    }
}
