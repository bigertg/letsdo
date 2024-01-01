package com.fubaorobot.letsdo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubaorobot.letsdo.bean.Todo;
import com.fubaorobot.letsdo.mapper.TodoMapper;
import com.fubaorobot.letsdo.service.TodoService;
import org.springframework.stereotype.Service;

/**
 * todo实例(Todo)表服务实现类
 *
 * @author tanghengqi
 * @since 2024-01-01 21:14:52
 */
@Service("todoService")
public class TodoServiceImpl extends ServiceImpl<TodoMapper, Todo> implements TodoService {

}

