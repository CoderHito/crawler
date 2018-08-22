package com.hitol.crawler.demo.manager.impl;

import com.hitol.crawler.demo.manager.WebPageManager;
import com.hitol.crawler.demo.model.WebPage;
import com.hitol.crawler.demo.repository.WebPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebPageManagerImpl implements WebPageManager {
    @Autowired
    private WebPageRepository repository;

    @Override
    public int saveUrlInfo(WebPage webPage) {
        repository.save(webPage);
        return 0;
    }
}
