package com.fubaorobot.letsdo.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fubaorobot.letsdo.bean.essense.ResponsData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * todo筹码(TodoChip)表实体类
 *
 * @author tanghengqi
 * @since 2024-01-01 21:08:32
 */



@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("todo_chip")
@Accessors(chain = true)
public class TodoChip extends ResponsData {
    //主键
    @TableId(type = IdType.AUTO)
    private Integer id;
    //筹码
    private String chipValue;
    //类型
    private String type;

}

