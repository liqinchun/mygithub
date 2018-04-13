package com.diploma.spider_project.contrller;

import com.diploma.spider_project.mysql.dao.TypeRepository;
import com.diploma.spider_project.mysql.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class TypeContrller {
    @Autowired
    private TypeRepository typeRepository;

    public String listType(Model model){

        List<Type> cs=typeRepository.findAll();

        model.addAttribute("cs", cs);
        return "listType";
    }
}
