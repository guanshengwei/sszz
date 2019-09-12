package com.shunaier.demo.biz.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.*;
import java.util.Set;
import java.util.concurrent.Callable;

/**
 * 系统异常枚举
 * @author gsw
 */
public class RedisCacheUtil implements Cache {


    private final Logger logger = LoggerFactory.getLogger(RedisCacheUtil.class);

    private String name;
    private RedisTemplate<String, Object> redisTemplate;

    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public Object getNativeCache() {
        return this.redisTemplate;
    }


    @Override
    public ValueWrapper get(Object key) {
        final String keyf = (String) key;
        Object object;
        try {
            object = redisTemplate.execute((RedisCallback<Object>) connection -> {
                byte[] jkey = (name + ":" + keyf).getBytes();
                byte[] value = connection.get(jkey);
                if (value == null) {
                    return null;
                }
                return toObject(value);
            });
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
        return (object != null ? new SimpleValueWrapper(object) : null);
    }


    @Override
    public <T> T get(Object key, Class<T> type) {
        return null;
    }

    @Override
    public <T> T get(Object o, Callable<T> callable) {
        return null;
    }


    @Override
    public void put(Object key, Object value) {
        final String keyf = (String) key;
        final Object valuef = value;
        try {
            redisTemplate.execute((RedisCallback<Long>) connection -> {
                byte[] valueb = toByteArray(valuef);
                byte[] jkey = (name + ":" + keyf).getBytes();
                connection.set(jkey, valueb);
                return 1L;
            });
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        return null;
    }


    @Override
    public void evict(Object key) {
        try {
            final String keyf = (String) key;
            redisTemplate.execute((RedisCallback<Long>) connection -> {
                byte[] jkey = (name + ":" + keyf).getBytes();
                return connection.del(jkey);
            });
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    @Override
    public void clear() {
        // 清楚缓存，需要根据Cache的name属性，在redis中模糊查询相关key值的集合，并全部删除
        try {
            redisTemplate.execute((RedisCallback<String>) connection -> {
                byte[] jkey = (name + ":*").getBytes();
                Set<byte[]> fields = connection.keys(jkey);
                byte[][] keyss = new byte[fields.size()][];
                int i = 0;
                for (byte[] bs : fields) {
                    keyss[i] = bs;
                    i++;
                }
                connection.del(keyss);
                return "ok";
            });
        } catch (Exception e) {
            logger.error("RedisCache.clear:name {}" + e.getMessage(), e);
        }
    }

    /**
     * 描述 : <Object转byte[]>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @param obj
     * @return
     */
    private byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            logger.info("toByteArray转换异常", ex);
        }
        return bytes;
    }

    /**
     * 描述 : <byte[]转Object>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @param bytes
     * @return
     */
    private Object toObject(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException | ClassNotFoundException ex) {
            logger.info("IOException | ClassNotFoundException",ex);
        }
        return obj;
    }

}
