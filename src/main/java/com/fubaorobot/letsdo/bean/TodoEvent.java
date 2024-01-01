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
 * todo事件(TodoEvent)表实体类
 *
 * @author tanghengqi
 * @since 2024-01-01 21:07:21
 */



@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("todo_event")
@Accessors(chain = true)
public class TodoEvent extends ResponsData {
    //主键
    @TableId(type = IdType.AUTO)
    private Integer id;
    //标题
    private String title;
    //内容
    private String content;
    //类别
    private String category;
    //图片url
    private String imageUrl;
    //类型
    private String type;

}

