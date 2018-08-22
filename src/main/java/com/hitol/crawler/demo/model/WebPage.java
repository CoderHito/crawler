package com.hitol.crawler.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*
* @author hitol 
* @date 2018/8/21 下午10:32
*/
@Entity
@Table(name = "web_page")
public class WebPage {
    @Id
    @Column(length = 32)
    private String id;

    public enum PageType {
        user,song, playlist, playlists;
    }

    public enum Status {
        crawled, uncrawl;
    }

    @Column(length = 100)
    private String url;
    @Column(length = 100)
    private String title;
//    private PageType type;
//    private Status status;
//    private String html;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public PageType getType() {
//        return type;
//    }
//
//    public void setType(PageType type) {
//        this.type = type;
//    }
//
//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }
//
//    public String getHtml() {
//        return html;
//    }
//
//    public void setHtml(String html) {
//        this.html = html;
//    }

}
