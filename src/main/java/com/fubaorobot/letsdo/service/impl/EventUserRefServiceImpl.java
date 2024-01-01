package com.fubaorobot.letsdo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fubaorobot.letsdo.mapper.EventUserRefMapper;
import com.fubaorobot.letsdo.bean.EventUserRef;
import com.fubaorobot.letsdo.service.EventUserRefService;
import org.springframework.stereotype.Service;

/**
 * 用户事件关系(EventUserRef)表服务实现类
 *
 * @author tanghengqi
 * @since 2024-01-01 21:42:44
 */
@Service("eventUserRefService")
public class EventUserRefServiceImpl extends ServiceImpl<EventUserRefMapper, EventUserRef> implements EventUserRefService {

}

