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
 * 用户事件关系(EventUserRef)表实体类
 *
 * @author tanghengqi
 * @since 2024-01-01 21:42:44
 */



@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("event_user_ref")
@Accessors(chain = true)
public class EventUserRef extends ResponsData {
    //主键
    @TableId(type = IdType.AUTO)
    private Integer id;
    //用户
    private Integer userid;
    //事件
    private Integer eventId;
    //类型
    private String type;

}

