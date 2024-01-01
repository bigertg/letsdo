package com.fubaorobot.letsdo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubaorobot.letsdo.bean.User;
import com.fubaorobot.letsdo.mapper.UserMapper;
import com.fubaorobot.letsdo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * user用户
 *
 * @author makejava
 * @since 2023-12-31 20:27:38
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

