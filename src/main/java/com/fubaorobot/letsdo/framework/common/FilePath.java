package com.fubaorobot.letsdo.framework.common;

/**
 * Author：tanghengqi
 * Date：2021-06-25 22:43
 * Description：<描述>
 * @author tanghengqi
 */
public enum FilePath {


    MEDIA(GlobalComponent.mediaFilePath),PACKAGE(GlobalComponent.packageFilePath);


    private String value;

    FilePath(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
