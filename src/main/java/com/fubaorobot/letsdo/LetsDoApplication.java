package com.fubaorobot.letsdo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@MapperScan(basePackages = {"com.fubaorobot.letsdo.mapper"})
@Slf4j
@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class LetsDoApplication {

    public static void main(String[] args) {
        try{
            SpringApplication.run(LetsDoApplication.class, args);
            log.info("--------------------companyadmin--启动成功----------------------");
        }
        catch (Exception e) {
            log.info("--------------------companyadmin--启动失败----------------------");
            log.info(e.toString());
        }
    }

}
