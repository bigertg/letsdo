package com.fubaorobot.letsdo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubaorobot.letsdo.bean.TodoChip;
import com.fubaorobot.letsdo.mapper.TodoChipMapper;
import com.fubaorobot.letsdo.service.TodoChipService;
import org.springframework.stereotype.Service;

/**
 * todo筹码(TodoChip)表服务实现类
 *
 * @author tanghengqi
 * @since 2024-01-01 21:08:32
 */
@Service("todoChipService")
public class TodoChipServiceImpl extends ServiceImpl<TodoChipMapper, TodoChip> implements TodoChipService {

}

