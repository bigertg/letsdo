package com.fubaorobot.letsdo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubaorobot.letsdo.bean.TodoEvent;
import com.fubaorobot.letsdo.mapper.TodoEventMapper;
import com.fubaorobot.letsdo.service.TodoEventService;
import org.springframework.stereotype.Service;

/**
 * todo事件(TodoEvent)表服务实现类
 *
 * @author tanghengqi
 * @since 2024-01-01 21:07:28
 */
@Service("todoEventService")
public class TodoEventServiceImpl extends ServiceImpl<TodoEventMapper, TodoEvent> implements TodoEventService {

}

