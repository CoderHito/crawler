package com.hitol.crawler.demo.crawler.task;

import com.hitol.crawler.demo.manager.WebPageManager;
import com.hitol.crawler.demo.model.WebPage;
import com.hitol.crawler.demo.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestTask {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private WebPageManager manager;

    @Scheduled(cron="*/5 * * * * *")
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));

//        WebPage webPage = new WebPage();
//        webPage.setTitle("llll");
//        webPage.setUrl("LLL");
//        webPage.setId(UUID.getUuid());
//
//        manager.saveUrlInfo(webPage);

    }

}
