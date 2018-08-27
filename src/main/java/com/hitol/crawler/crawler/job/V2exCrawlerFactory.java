package com.hitol.crawler.crawler.job;

import com.hitol.crawler.crawler.music.MusicCrawler;
import com.hitol.crawler.manager.WebPageManager;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;

public class V2exCrawlerFactory implements CrawlController.WebCrawlerFactory {

    WebPageManager manager;

    public V2exCrawlerFactory(WebPageManager manager){
        this.manager = manager;
    }

    @Override
    public WebCrawler newInstance() throws Exception {
        return new V2exCrawler(manager);
    }
}
