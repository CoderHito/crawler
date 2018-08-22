package com.hitol.crawler.manager.impl;

import com.hitol.crawler.manager.WebPageManager;
import com.hitol.crawler.model.JobInfo;
import com.hitol.crawler.model.WebPage;
import com.hitol.crawler.repository.JobInfoRepository;
import com.hitol.crawler.repository.WebPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebPageManagerImpl implements WebPageManager {
    @Autowired
    private WebPageRepository webPageRepository;

    @Autowired
    private JobInfoRepository jobInfoRepository;

    @Override
    public int saveUrlInfo(WebPage webPage) {
        webPageRepository.save(webPage);
        return 0;
    }

    @Override
    public int saveJobInfo(JobInfo jobInfo) {
        jobInfoRepository.save(jobInfo);
        return 0;
    }


}
