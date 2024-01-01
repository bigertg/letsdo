package com.fubaorobot.letsdo.framework.security.handler;


import com.alibaba.fastjson.JSON;
import com.fubaorobot.letsdo.bean.essense.AjaxResult;
import com.fubaorobot.letsdo.framework.utils.ServletUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * @Author tanghengqi
 * @Description  认证失败处理类 返回未授权
 * @Date 16:33 2021/6/17
 **/
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable
{
    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
    {
        int code = 401;
        String msg = "认证失败，无法访问系统资源";
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.error(code, msg)));
    }
}
