package com.hitol.crawler.demo.repository;

import com.hitol.crawler.demo.model.WebPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebPageRepository extends JpaRepository<WebPage,String> {

}
