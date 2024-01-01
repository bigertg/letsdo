package com.fubaorobot.letsdo.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fubaorobot.letsdo.bean.TodoEvent;
import com.fubaorobot.letsdo.bean.essense.AjaxResult;
import com.fubaorobot.letsdo.service.TodoEventService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * todo事件(TodoEvent)表控制层
 *
 * @author tanghengqi
 * @since 2024-01-01 21:07:21
 */
@RestController
@RequestMapping("todoEvent")
public class TodoEventController {
    /**
     * 服务对象
     */
    @Resource
    private TodoEventService todoEventService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param todoEvent 查询实体
     * @return 所有数据
     */
    @GetMapping
    public AjaxResult selectAll(Page<TodoEvent> page, TodoEvent todoEvent) {
        return AjaxResult.success(this.todoEventService.page(page, new QueryWrapper<>(todoEvent)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult selectOne(@PathVariable Serializable id) {
        return AjaxResult.success(this.todoEventService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param todoEvent 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody TodoEvent todoEvent) {
        return AjaxResult.success(this.todoEventService.save(todoEvent));
    }

    /**
     * 修改数据
     *
     * @param todoEvent 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody TodoEvent todoEvent) {
        return AjaxResult.success(this.todoEventService.updateById(todoEvent));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("idList") List<Integer> idList) {
        return AjaxResult.success(this.todoEventService.removeByIds(idList));
    }
}

