package com.diploma.mysql.model;

import javax.persistence.*;

@Entity
@Table(name="urlvo")
public class Urlvo {
    private String urlId;
    private String url;
    private String name;

    @Id
    @Column(name = "urlId")
    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
