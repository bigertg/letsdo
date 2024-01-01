package com.fubaorobot.letsdo.bean.essense;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


/**
 * @author admin
 */

@ToString
@Data
public class AjaxResult implements Serializable {
 
    private static final long serialVersionUID = -78534440368547L;

    /** 状态码 */
    public int status;

    /** 返回内容 */
    public String msg;

    /** 数据对象 */
    public Object data;



    public AjaxResult()
    {
        status = 100;
        msg="Unknow!";
        data="";
    }

    public AjaxResult(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public AjaxResult reportOperationResult(Integer changeItemCount)
    {
        if(changeItemCount >0) {
            return operationSuccess(changeItemCount);
        }
        else {
            return operationFailCondition();
        }
    }


    /**
     * 返回成功消息（修改，新增等）
     * @param changeItemCount 修改数量
     * @return 成功消息
     */
    private AjaxResult operationSuccess(Integer changeItemCount)
    {
        status = 200;
        msg="Operatoio Success!";
        data="当前修改成功，修改数量："+changeItemCount;
        return this;
    }

    /**
     * 返回成功消息（修改，新增等）
     * @return 成功消息
     */
    private AjaxResult operationSuccess()
    {
        status = 200;
        msg="Operatoio Success!";
        data="当前执行成功";
        return this;
    }

    private AjaxResult operationFailCondition()
    {
        status = 300;
        msg="Operatoio Fail!,Please check your selecting condition";
        data="当前执行成功，请确认检索条件";

        return this;
    }

    /**
     * 返回Exception错误信息
     * @param d
     * @return
     */
    public AjaxResult operationFailException(String d) {

        status = 409;
        msg="Operatoio fail! unexcpetional error!";
        data=d;

        return this;
    }


    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static AjaxResult error(String msg, Object data)
    {
        return new AjaxResult(500, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param msg 数据对象
     * @return 成功消息
     */
    public static AjaxResult error(String msg) {
        return new AjaxResult(500,msg,null);
    }

    public static AjaxResult error(Integer status,String msg) {
        return new AjaxResult(status,msg,null);
    }

    /**
     * 返回成功消息
     *
     * @param data 数据对象
     * @return 成功消息
     */
    public static AjaxResult success(Object data) {
     return success("success!",data);
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static AjaxResult success(Boolean b) {
        if(b) {
            return new AjaxResult().operationSuccess();
        }
        else {
            return new AjaxResult().operationFailCondition();
        }
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static AjaxResult success(String msg, Object data)
    {
        return new AjaxResult(200, msg, data);
    }

}
