package com.fubaorobot.letsdo.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fubaorobot.letsdo.bean.TodoChip;
import com.fubaorobot.letsdo.bean.essense.AjaxResult;
import com.fubaorobot.letsdo.service.TodoChipService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * todo筹码(TodoChip)表控制层
 *
 * @author tanghengqi
 * @since 2024-01-01 21:08:32
 */
@RestController
@RequestMapping("todoChip")
public class TodoChipController {
    /**
     * 服务对象
     */
    @Resource
    private TodoChipService todoChipService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param todoChip 查询实体
     * @return 所有数据
     */
    @GetMapping
    public AjaxResult selectAll(Page<TodoChip> page, TodoChip todoChip) {
        return AjaxResult.success(this.todoChipService.page(page, new QueryWrapper<>(todoChip)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult selectOne(@PathVariable Serializable id) {
        return AjaxResult.success(this.todoChipService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param todoChip 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody TodoChip todoChip) {
        return AjaxResult.success(this.todoChipService.save(todoChip));
    }

    /**
     * 修改数据
     *
     * @param todoChip 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody TodoChip todoChip) {
        return AjaxResult.success(this.todoChipService.updateById(todoChip));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("idList") List<Long> idList) {
        return AjaxResult.success(this.todoChipService.removeByIds(idList));
    }
}

