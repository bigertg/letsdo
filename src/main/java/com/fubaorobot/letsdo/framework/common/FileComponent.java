package com.fubaorobot.letsdo.framework.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Component
@Slf4j
public class FileComponent {


    private static String pthsPatterns;
    @Value("${fubaorobot.media.http.pre}")
    public void setPthsPatterns(String Patterns)
    {
        pthsPatterns = Patterns;
    }

    private static String filePathPre;

    @Value("${fubaorobot.file.path}")
    public void setFilePathPre(String str)
    {
        filePathPre = str;
    }

    public static String FileUpload(MultipartFile file , FilePath path) {

        System.out.println("----"+GlobalComponent.domain+"===="+GlobalComponent.mediaFilePath);
        String filePath = filePathPre +path.getValue();
        if (file == null) {
            return "file is empty!! ";
        }
        String orgfileName = file.getOriginalFilename();
        String suffix = orgfileName.substring(orgfileName.lastIndexOf("."));
        String fileName = RandomComponent.getRandomString(16)+ System.currentTimeMillis() +RandomComponent.getRandomString(8)+ suffix;
        creatFile(filePath);
        String filefullpath = filePath +fileName;
        File dest = new File(filefullpath);
        log.info("add a file to :"+filefullpath);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            return "";
        }
        //返回一个绝对路径
        return GlobalComponent.domain+pthsPatterns+path.getValue()+fileName;
    }

    protected static void creatFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * @Author zx
     * @Description // 通过传进来的后缀判断类型
     * @Date 14:29 2021/6/24
     * @Param suffix
     * @return suffix
     **/
    public static String suffixType(String suffix){
        /* 根据后缀名判断类型 */
        switch (suffix) {
            case ".jpg":
            case ".png":
            case ".jpeg":
                suffix="图片";
                break;
            case ".gif":
                suffix="动图";
                break;
            case ".avi":
            case ".rmvb":
            case ".mp4":
            case ".asf":
            case ".divx":
            case ".mpg":
            case ".mpeg":
                suffix="视频";
                break;
            case ".mp3":
                suffix="音频";
                break;
            case ".txt":
                suffix="文本";
                break;
            default:
        }
        return suffix;
    }
}
