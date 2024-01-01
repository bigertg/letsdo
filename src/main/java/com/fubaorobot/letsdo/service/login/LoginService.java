package com.fubaorobot.letsdo.service.login;

import com.fubaorobot.letsdo.bean.login.LoginUser;
import com.fubaorobot.letsdo.framework.constant.Constants;
import com.fubaorobot.letsdo.framework.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author tanghengqi
 * @Description   登入校验方法
 * @Date 16:02 2021/6/17
 **/
@Component
public class LoginService
{
    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @return 结果
     */
    public Map<String,Object> login(String username, String password)
    {
        // 用户验证
        Authentication authentication = null;
        try
        {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (BadCredentialsException e) {
            throw new BaseException("用户名或密码输入错误");
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Map<String, Object> map = new HashMap<>();
        // 生成token
        String token = tokenService.createToken(loginUser);
        boolean soEasy = Constants.INIT_PASSWORD.equals(password);
        map.put(Constants.TOKEN,token);
        map.put(Constants.USER,loginUser.getUser());
        map.put(Constants.PASSWORD_SO_EASY,soEasy);
        return map;
    }

}
