package com.shunaier.demo.biz.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 *
 * 分布式锁配置  *
 *
 * @author 王金龙
 */
@Configuration
public class RedissonConfig {

    @Resource
    private JedisProperties prop;

    @Bean
    public RedissonClient redissonClient(){

        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + prop.getHost() + ":" + prop.getPort())
                .setPassword(prop.getPassword()).setDatabase(prop.getDatabase());
        return Redisson.create(config);
    }

}
