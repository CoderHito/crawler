package com.hitol.crawler;

import com.hitol.crawler.model.ProxyEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisTemplate<String, ProxyEntity> redisTemplate;
//    private StringRedisTemplate redisTemplate;

    @Test
    public void testRedis() {
//        logger.info("测试redis");
//        for (int i = 0; i < 5; i++) {
//            redisTemplate.opsForValue().set("aa" + i, i + "");
//        }

//        for (int i = 0; i < 5; i++) {
//            redisTemplate.opsForValue().getOperations().delete("aa" + i);
//        }


        Set<String> keys = redisTemplate.keys("*");
        for (String key : keys) {
            logger.info("key = {},value = {}",key,getByKey(key).toString());
        }
    }

    private Object getByKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
