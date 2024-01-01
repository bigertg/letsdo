package com.fubaorobot.letsdo.service.login;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fubaorobot.letsdo.bean.login.LoginUser;
import com.fubaorobot.letsdo.bean.User;
import com.fubaorobot.letsdo.service.UserService;
import com.fubaorobot.letsdo.framework.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * @Author tanghengqi
 * @Description  用户验证处理
 * @Date 16:03 2021/6/17
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",username);
        User user = userService.getOne(queryWrapper);
        if (StringUtils.isNull(user))
        {
            log.info("登录用户：{} 不存在.", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }
        return new LoginUser(user, new HashSet<>());
    }

}
