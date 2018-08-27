package com.hitol.crawler.crawler;

import com.hitol.crawler.manager.WebPageManager;
import com.hitol.crawler.model.ProxyEntity;
import com.hitol.crawler.repository.RedisRepository;
import com.hitol.crawler.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Component
public class TestTask {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private WebPageManager manager;

    @Autowired
    private RedisTemplate<String, ProxyEntity> redisTemplate;

    @Autowired
    private RedisRepository redisRepository;

    //    @Scheduled(cron = "*/5 * * * * *")
    public void reportCurrentTime() {
//       logger.info("现在时间：" + dateFormat.format(new Date()));

//        WebPage webPage = new WebPage();
//        webPage.setTitle("llll");
//        webPage.setUrl("LLL");
//        webPage.setId(UUID.getUuid());
//
//        manager.saveUrlInfo(webPage);

    }



    //    @Scheduled(cron = "*/5 * * * * *")
    public void testRedis() {
        logger.info("测试redis");
        Set<String> keys = redisTemplate.keys("*");
        for (String key : keys) {
            logger.info("key = {},value = {}", key, getByKey(key).toString());
        }
    }

    private Object getByKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
