package com.hitol.crawler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job_info")
public class JobInfo {
    @Id
    @Column(length = 32)
    private String id;
    @Column(length = 100)
    private String title;
    @Column(length = 100)
    private String href;

    public JobInfo(String title, String href) {
        this.title = title;
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
