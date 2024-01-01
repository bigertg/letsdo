package com.fubaorobot.letsdo.service.dict;

import com.fubaorobot.letsdo.bean.dict.DictBO;
import com.fubaorobot.letsdo.bean.dict.DictDTO;
import com.fubaorobot.letsdo.bean.dict.DictReq;

import java.util.List;

/**
 * 数据字典表(Dict)表服务接口
 *
 * @author tanghengqi
 * @date 2021-07-09 10:59:29
 */
public interface DictService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DictBO selectDictById(Integer id);

    /**
     * 查询多条数据
     *
     * @param dict 实例对象
     * @return 对象列表
     */
    List<DictBO> selectDictList(DictDTO dict);

    /**
     * 新增数据
     *
     * @param dict 实例对象
     * @return 结果
     */
    int insertDict(DictDTO dict);

    /**
     * 修改数据
     *
     * @param dict 实例对象
     * @return 结果
     */
    int updateDict(DictDTO dict);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 结果
     */
    int deleteDictById(Integer id);


    /**
     * 通过dictType查询数据列表
     *
     * @param typeCode 类型编码
     * @return 数据列表
     */
    List<DictReq> selectDictByTypeCode(String typeCode);
}
