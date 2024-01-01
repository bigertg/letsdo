package com.fubaorobot.letsdo.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fubaorobot.letsdo.bean.essense.ResponsData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-06-09 11:50:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
@Accessors(chain = true)
public class User extends ResponsData implements Serializable {
    private static final long serialVersionUID = 891909853430163112L;

    /**
     * 主键编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String userPassword;

}