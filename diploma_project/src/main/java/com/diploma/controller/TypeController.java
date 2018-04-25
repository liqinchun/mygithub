package com.diploma.controller;

import com.diploma.mysql.dao.TypeRepository;
import com.diploma.mysql.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestMapping("/type")
@Controller
public class TypeController {
    @Autowired
    private TypeRepository typeRepository;

    @RequestMapping("index")
    public String test(){
        return "top";
    }
}
