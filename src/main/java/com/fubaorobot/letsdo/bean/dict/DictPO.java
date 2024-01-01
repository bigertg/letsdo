package com.fubaorobot.letsdo.bean.dict;

import lombok.Data;
import lombok.ToString;

/**
 * 数据字典表(Dict)实体类
 *
 * @author tanghengqi
 * @since 2021-07-09 10:59:22
 */
@ToString
@Data
public class DictPO {
    private static final long serialVersionUID = 532571324219345488L;
    /**
     * 字典主键编号
     */
    private Integer id;
    /**
     * 字典类型
     */
    private String dictType;
    /**
     * 类型编码
     */
    private String typeCode;
    /**
     * 字典值
     */
    private String dictValue;
    /**
     * 字典编码
     */
    private String dictCode;
    /**
     * 是否启用:1-是;0-否
     */
    private Object state;


}
