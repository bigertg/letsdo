package com.fubaorobot.letsdo.framework.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GlobalComponent {

    public static String domain;
    @Value("${fubaorobot.domain}")
    public void setDomain(String d)
    {
        domain = d;
    }

    public static String mediaFilePath;
    @Value("${fubaorobot.file.media.path}")
    public void setMediaFilePath(String d)
    {
        mediaFilePath = d;
    }

    public static String packageFilePath;
    @Value("${fubaorobot.file.package.path}")
    public void setPackageFilePath(String d)
    {
        packageFilePath = d;
    }
}
