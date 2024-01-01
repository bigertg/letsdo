package com.fubaorobot.letsdo.framework.config;
/**
 * Project Name:ebu-framework  
 * File Name:EhcacheConfig.java  
 * Package Name:com.fubaorobot.neromax.config
 * Date:2020年1月17日  
 *
 */

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


/**
 * EhcacheConfig.java <br/>
 * <b>功能描述：<b><br/>
 *
 * ehcache 配置管理器.<br/>
 *
 * @author
 * @since 1.0 2020年1月17日  
 * @lastmodified 2020年1月17日
 */
@Configuration
public class EhcacheConfig
{
    @Value("${biz.cache.name}")
    private  String cacheName;

    @Bean(name = "ehCache")
    public Cache getCache(CacheManager ehCacheManager) {
        Cache cache = ehCacheManager.getCache(cacheName);
        if(cache == null) {
            ehCacheManager.addCache(cacheName);
            cache = ehCacheManager.getCache(cacheName);
        }
        return cache;
    }

    @Bean(name = "ehCacheManager")
    public CacheManager cacheManager(EhCacheManagerFactoryBean bean) {
        return bean.getObject();
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        //不要使用ehcache.xml 防止spring-boot 自动注入
        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("cache-ehcache.xml"));
        cacheManagerFactoryBean.setShared(true);
        // 设置完属性后，cacheManagerFactoryBean会执行afterProertiesSet()方法，
        // 所以不能在这里直接执行cacheManagerFactoryBean.getObject(),直接执行的话，因为在afterPropertiesSet()方法之前执行，所以：getObject()会得到null值
        return cacheManagerFactoryBean;
    }

    public String getCacheName()
    {
        return cacheName;
    }

    public void setCacheName(String cacheName)
    {
        this.cacheName = cacheName;
    }


}