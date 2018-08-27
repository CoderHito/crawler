package com.hitol.crawler;

import com.hitol.crawler.model.ProxyEntity;
import com.hitol.crawler.repository.RedisRepository;
import com.hitol.crawler.util.HttpUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedInputStream;
import java.net.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxyIpTest {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RedisTemplate<String, ProxyEntity> redisTemplate;
    @Autowired
    private RedisRepository redisRepository;

    @Test
    public void testProxyIp() throws Exception {
//        while (true) {
//            ProxyEntity proxyEntity = redisRepository.getRandomly();
//            System.setProperty("http.maxRedirects", "50");
//            System.getProperties().setProperty("proxySet", "true");
//            System.getProperties().setProperty("http.proxyHost", proxyEntity.getIp());
//            System.getProperties().setProperty("http.proxyPort", String.valueOf(proxyEntity.getPort()));
//
//            int responseCode = HttpUtil.getResponseCode("http://www.baidu.com");
//            if (responseCode == 200) {
//                logger.info(proxyEntity.getIp() + ":" + proxyEntity.getPort() + "可以使用!");
//                return;
//            }
//
//        }
    }



    public void getIpInfo() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("Local HostAddress: " + addr.getHostAddress());
        String hostname = addr.getHostName();
        System.out.println("Local host name: " + hostname);
    }

}
