package com.fubaorobot.letsdo.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fubaorobot.letsdo.bean.EventUserRef;
import com.fubaorobot.letsdo.service.EventUserRefService;
import org.springframework.web.bind.annotation.*;
import com.fubaorobot.letsdo.bean.essense.AjaxResult;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户事件关系(EventUserRef)表控制层
 *
 * @author tanghengqi
 * @since 2024-01-01 21:42:44
 */
@RestController
@RequestMapping("eventUserRef")
public class EventUserRefController {
    /**
     * 服务对象
     */
    @Resource
    private EventUserRefService eventUserRefService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param eventUserRef 查询实体
     * @return 所有数据
     */
    @GetMapping
    public AjaxResult selectAll(Page<EventUserRef> page, EventUserRef eventUserRef) {
        return AjaxResult.success(this.eventUserRefService.page(page, new QueryWrapper<>(eventUserRef)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult selectOne(@PathVariable Serializable id) {
        return AjaxResult.success(this.eventUserRefService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param eventUserRef 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody EventUserRef eventUserRef) {
        return AjaxResult.success(this.eventUserRefService.save(eventUserRef));
    }

    /**
     * 修改数据
     *
     * @param eventUserRef 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody EventUserRef eventUserRef) {
        return AjaxResult.success(this.eventUserRefService.updateById(eventUserRef));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("idList") List<Long> idList) {
        return AjaxResult.success(this.eventUserRefService.removeByIds(idList));
    }
}

