package com.diploma.service.impl;

import com.diploma.mysql.dao.TypeRepository;
import com.diploma.mysql.model.Type;
import com.diploma.mysql.model.Urlvo;
import com.diploma.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("typeService")
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;
    @Override
    public List<Type>  getAllType() {

        return typeRepository.findAll();
    }


}
