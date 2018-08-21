package com.hitol.crawler.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CrawlerApplication {

    @RequestMapping("/")
    public String index (){
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(CrawlerApplication.class, args);
    }
}
