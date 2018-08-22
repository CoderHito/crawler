package com.hitol.crawler.manager;

import com.hitol.crawler.model.JobInfo;
import com.hitol.crawler.model.WebPage;

public interface WebPageManager {
    int saveUrlInfo(WebPage webPage);

    int saveJobInfo(JobInfo jobInfo);
}
