package com.fubaorobot.letsdo.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fubaorobot.letsdo.bean.essense.ResponsData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * todo实例(Todo)表实体类
 *
 * @author tanghengqi
 * @since 2024-01-01 21:09:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("todo")
@Accessors(chain = true)
public class Todo extends ResponsData {
    //主键
    @TableId(type = IdType.AUTO)
    private Integer id;
    //事件id
    private Integer eventId;
    //事件id
    private Integer eventTitle;
    //事件交互参数
    private String eventArgs;
    //筹码id
    private Integer chipId;
    //筹码参数
    private String chipArgs;
    //监督者
    private Integer supervisor;
    //执行者
    private Integer executor;
    //状态
    private String state;

    }

