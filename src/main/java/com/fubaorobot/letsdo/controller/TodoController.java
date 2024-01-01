package com.fubaorobot.letsdo.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fubaorobot.letsdo.bean.Todo;
import com.fubaorobot.letsdo.bean.essense.AjaxResult;
import com.fubaorobot.letsdo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * todo实例(Todo)表控制层
 *
 * @author tanghengqi
 * @since 2024-01-01 21:14:50
 */
@RestController
@RequestMapping("todo")
public class TodoController {
    /**
     * 服务对象
     */
    @Resource
    private TodoService todoService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param todo 查询实体
     * @return 所有数据
     */
    @GetMapping
    public AjaxResult selectAll(Page<Todo> page, Todo todo) {
        return AjaxResult.success(this.todoService.page(page, new QueryWrapper<>(todo)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult selectOne(@PathVariable Serializable id) {
        return AjaxResult.success(this.todoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param todo 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody Todo todo) {
        return AjaxResult.success(this.todoService.save(todo));
    }

    /**
     * 修改数据
     *
     * @param todo 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody Todo todo) {
        return AjaxResult.success(this.todoService.updateById(todo));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("idList") List<Long> idList) {
        return AjaxResult.success(this.todoService.removeByIds(idList));
    }
}

