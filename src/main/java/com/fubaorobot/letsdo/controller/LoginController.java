package com.fubaorobot.letsdo.controller;

import com.fubaorobot.letsdo.bean.User;
import com.fubaorobot.letsdo.bean.essense.AjaxResult;
import com.fubaorobot.letsdo.bean.login.LoginBody;
import com.fubaorobot.letsdo.bean.login.LoginUser;
import com.fubaorobot.letsdo.service.login.LoginService;
import com.fubaorobot.letsdo.service.login.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * @author：tanghengqi
 * @date：2021-06-16 16:19
 * @description：<描述>
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private TokenService tokenService;

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody)
    {
        return AjaxResult.success(loginService.login(loginBody.getUsername(), loginBody.getPassword()));
    }


    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("/getInfo")
    public AjaxResult getInfo()
    {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        LoginUser loginUser = tokenService.getLoginUser(requestAttributes.getRequest());
        User user = loginUser.getUser();
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        return AjaxResult.success(map);
    }


}
