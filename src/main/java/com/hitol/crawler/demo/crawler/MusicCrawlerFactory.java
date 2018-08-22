package com.hitol.crawler.demo.crawler;

import com.hitol.crawler.demo.manager.WebPageManager;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;

public class MusicCrawlerFactory implements CrawlController.WebCrawlerFactory {

    WebPageManager manager;

    public MusicCrawlerFactory(WebPageManager manager){
        this.manager = manager;
    }

    @Override
    public WebCrawler newInstance() throws Exception {
        return new MusicCrawler(manager);
    }
}
