package com.fubaorobot.letsdo.service.login; /**
 * Project Name:ebu-framework
 * File Name:EhcacheService.java
 * Package Name:com.fubao.framework.cache
 * Date:2020年1月17日
 *
 */


import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * EhcacheService.java <br/>
 * <b>功能描述：<b><br/>
 *
 * ehcache 缓存操作.<br/>
 *
 * @author
 * @since 1.0 2020年1月17日
 * @lastmodified 2020年1月17日
 */
@Component
public class EhcacheService
{

    @Autowired
    private Cache ehCache ;


    public void putValue(String key , Object val) {
        Element e = new Element(key,val);
        ehCache.put(e);
    }

    public void putValue(String key , Object val,Integer timeToIdleSeconds,Integer timeToLiveSeconds) {
        Element e = new Element(key,val,timeToIdleSeconds,timeToLiveSeconds);
        ehCache.put(e);
    }

    public void putValue(String key , Object val,Integer timeToLiveSeconds) {
        Element e = new Element(key,val,0,timeToLiveSeconds);
        ehCache.put(e);
    }

    @SuppressWarnings("unchecked")
    public <T> T getValue(String key) {
        T val = null;
        Element e = ehCache.get(key);
        if(e != null) {
            val = (T)e.getObjectValue();
        }
        return val ;
    }

    public Boolean deleteVal(String key) {

        return ehCache.remove(key);
    }

    /**
     * 判断key是否在缓存中 <br/>
     *
     * @param key
     * @return  Boolean 是否存在
     */
    public Boolean isKeyExit(String key) {

        return ehCache.isKeyInCache(key);
    }

    /**
     * 获取本应用下所有key. <br/>
     *
     * @return  返回所有key
     */
    @SuppressWarnings("unchecked")
    public List<String> getKeysApp(){

        return ehCache.getKeys();
    }




}

