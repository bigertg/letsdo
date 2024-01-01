package com.fubaorobot.letsdo.service.dict.impl;

import com.fubaorobot.letsdo.bean.dict.DictBO;
import com.fubaorobot.letsdo.bean.dict.DictDTO;
import com.fubaorobot.letsdo.bean.dict.DictReq;
import com.fubaorobot.letsdo.mapper.DictMapper;
import com.fubaorobot.letsdo.service.dict.DictService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 数据字典表(Dict)表服务实现类
 *
 * @author tanghengqi
 * @date 2021-07-09 10:59:33
 */
@Service("dictService")
public class DictServiceImpl implements DictService {

    @Autowired
    private DictMapper dictMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DictBO selectDictById(Integer id) {
        return dictMapper.selectDictById(id);
    }

    /**
     * 查询多条数据
     *
     * @param dict 实例对象
     * @return 对象列表
     */
    @Override
    public List<DictBO> selectDictList(DictDTO dict) {
        return dictMapper.selectDictList(dict);
    }

    /**
     * 新增数据
     *
     * @param dict 实例对象
     * @return 实例对象
     */
    @Override
    public int insertDict(DictDTO dict) {
        return dictMapper.insertDict(dict);
    }

    /**
     * 修改数据
     *
     * @param dict 实例对象
     * @return 实例对象
     */
    @Override
    public int updateDict(DictDTO dict) {
        return dictMapper.updateDict(dict);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteDictById(Integer id) {
        return dictMapper.deleteDictById(id);
    }

    /**
     * 通过dictType查询数据列表
     *
     * @param typeCode 类型编码
     * @return 数据列表
     */
    @Override
    public List<DictReq> selectDictByTypeCode(String typeCode) {
        return dictMapper.selectDictByTypeCode(typeCode);
    }
}
