package com.fubaorobot.letsdo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fubaorobot.letsdo.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * todo任务(Todo)表数据库访问层
 *
 * @author makejava
 * @since 2023-12-31 20:27:36
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

