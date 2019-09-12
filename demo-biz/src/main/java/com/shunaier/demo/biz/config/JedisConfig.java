package com.shunaier.demo.biz.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 系统异常枚举
 * @author gsw
 */
@Configuration
@EnableCaching
public class JedisConfig {
    private final Logger logger = LoggerFactory.getLogger(JedisConfig.class);

    @Resource
    private JedisProperties prop;

    @Bean(name = "jedisPoolConfig")
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(prop.getMaxTotal());
        config.setMaxIdle(prop.getMaxIdle());
        config.setMinIdle(prop.getMinIdle());
        config.setMaxWaitMillis(prop.getMaxWaitMillis());
        config.setTestOnBorrow(prop.isTestOnBorrow());
        config.setTestOnReturn(prop.isTestOnReturn());
        config.setTestWhileIdle(prop.isTestWhileIdle());
        config.setNumTestsPerEvictionRun(prop.getNumTestsPerEvictionRun());
        config.setMinEvictableIdleTimeMillis(prop.getMinEvictableIdleTimeMillis());
        config.setTimeBetweenEvictionRunsMillis(prop.getTimeBetweenEvictionRunsMillis());
        return config;
    }

    @Bean(name ="jedisConnectionFactory")
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        jedisConnectionFactory.setPort(prop.getPort());
        jedisConnectionFactory.setHostName(prop.getHost());
        jedisConnectionFactory.setTimeout(prop.getTimeOut());
        jedisConnectionFactory.setPassword(prop.getPassword());
        jedisConnectionFactory.setDatabase(prop.getDatabase());
        return jedisConnectionFactory;
    }

    @Bean(name ="redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        return template;
    }
    /**
     * 缓存管理器.
     * @param redisCacheUtil
     * @return
     */
    @Bean(name="cacheManager")
    public CacheManager cacheManager(@SuppressWarnings("rawtypes") Cache redisCacheUtil) {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<Cache> caches = new ArrayList<>();
        caches.add(redisCacheUtil);
        cacheManager.setCaches(caches);
        logger.info("----------redis cacheManager start");
        return cacheManager;
    }

    @Bean(name="redisCacheUtil")
    public Cache redisCacheUtil(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate){
        RedisCacheUtil redisCacheUtil = new RedisCacheUtil();
        redisCacheUtil.setRedisTemplate(redisTemplate);
        redisCacheUtil.setName("cajproduct");
        return redisCacheUtil;
    }


}
