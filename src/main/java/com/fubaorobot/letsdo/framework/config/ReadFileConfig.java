package com.fubaorobot.letsdo.framework.config;


import com.fubaorobot.letsdo.framework.common.GlobalComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * springboot项目访问外部文件资源：例如图片等
 */
@Configuration
public class ReadFileConfig implements WebMvcConfigurer {

    @Value("${fubaorobot.file.path}")
    private String filePath;
    @Value("${fubaorobot.file.media.patterns}")
    private String mediaPatterns;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //和页面有关的静态目录都放在项目的static目录下
        //上传的图片在E盘下的image目录下，访问路径如：http://localhost:8079/isee_imgs/upload/face/2019/11/21/1334343330.png
        //其中image/slt表示访问的前缀。"file:E:/image/slt/"是文件真实的存储路径
        String resourceLocations = "file:" + filePath;
        registry.addResourceHandler(mediaPatterns).addResourceLocations(resourceLocations+GlobalComponent.mediaFilePath);
    }
}
