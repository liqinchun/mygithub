package com.diploma.service;

import com.diploma.mysql.model.Urlvo;

public interface UrlService {
    public void findAllUrl();
    public void saveUrl(Urlvo urlvo);
}
