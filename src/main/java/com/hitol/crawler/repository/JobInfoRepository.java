package com.hitol.crawler.repository;

import com.hitol.crawler.model.JobInfo;
import com.hitol.crawler.model.WebPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobInfoRepository extends JpaRepository<JobInfo,String> {

}
