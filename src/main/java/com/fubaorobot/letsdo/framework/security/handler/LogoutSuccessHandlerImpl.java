package com.fubaorobot.letsdo.framework.security.handler;

import com.alibaba.fastjson.JSON;
import com.fubaorobot.letsdo.bean.essense.AjaxResult;
import com.fubaorobot.letsdo.bean.login.LoginUser;
import com.fubaorobot.letsdo.service.login.TokenService;
import com.fubaorobot.letsdo.framework.utils.ServletUtils;
import com.fubaorobot.letsdo.framework.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author tanghengqi
 * @Description  自定义推出类
 * @Date 16:40 2021/6/17
 **/
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler
{
    @Autowired
    private TokenService tokenService;

    /**
     * 退出处理
     * 
     * @return
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
    {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser))
        {
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getSign());
        }
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.error("200", "退出成功")));
    }
}
