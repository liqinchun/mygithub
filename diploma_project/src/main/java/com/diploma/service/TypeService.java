package com.diploma.service;

import com.diploma.mysql.model.Type;
import com.diploma.mysql.model.Urlvo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TypeService {
    public List<Type> getAllType();

}
