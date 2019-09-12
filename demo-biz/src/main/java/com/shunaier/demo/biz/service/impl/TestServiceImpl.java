package com.shunaier.demo.biz.service.impl;

import com.shunaier.demo.biz.dao.ComplaintOrderMapper;
import com.shunaier.demo.biz.model.bean.ComplaintOrder;
import com.shunaier.demo.biz.service.TestService;
import com.shunaier.demo.common.enums.SystemErrorEnum;
import com.shunaier.demo.common.exception.SNEBizException;
import com.shunaier.demo.common.util.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用途描述
 *
 * @author gsw
 * @version $Id: TestServiceImpl, v0.1
 * 
 * 
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @Resource
    private ComplaintOrderMapper complaintOrderMapper;

    @Override
    public ComplaintOrder getById(String id) {
        AssertUtil.isNotEmptyParam(id, "id");

        redisTemplate.opsForValue().get("a");

        ComplaintOrder complaintOrder = complaintOrderMapper.selectByPrimaryKey(id);

        RLock lock = redissonClient.getLock("test:id");
        if (!lock.tryLock()) {
            throw new  SNEBizException(SystemErrorEnum.SYSTEM_BUSY);
        }

        try {
            log.info("我拿到锁了");
        } finally {
            lock.unlock();
        }

        return complaintOrder;
    }

}
