package com.fubaorobot.letsdo.mapper;

import com.fubaorobot.letsdo.bean.dict.DictBO;
import com.fubaorobot.letsdo.bean.dict.DictDTO;
import com.fubaorobot.letsdo.bean.dict.DictReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据字典表(Dict)表数据库访问层
 *
 * @author tanghengqi
 * @date 2021-07-09 10:59:38
 */
public interface DictMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DictBO selectDictById(Integer id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dict 实例对象
     * @return 对象列表
     */
    List<DictBO> selectDictList(DictDTO dict);

    /**
     * 新增数据
     *
     * @param dict 实例对象
     * @return 影响行数
     */
    int insertDict(DictDTO dict);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Dict> 实例对象列表
     * @return 影响行数
     */
    int insertDictBatch(@Param("entities") List<DictDTO> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DictDTO> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<DictDTO> entities);

    /**
     * 修改数据
     *
     * @param dict 实例对象
     * @return 影响行数
     */
    int updateDict(DictDTO dict);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
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

