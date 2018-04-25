package com.diploma.controller;

import com.diploma.mysql.model.Category;
import com.diploma.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/catagory")
@Controller
public class CatagoryController {
    @Autowired
    private CatagoryService catagoryService;

    @RequestMapping("add_catagory")
    public String  addCatagory(Model model,String name){
        catagoryService.addCategory(name);
        List<Category> cs=catagoryService.getAllCatagory();
        model.addAttribute("cs",cs);
        return "admin/listCategory";
    }

    @RequestMapping("catagory_list")
    public String  getAllCatagory(Model model){
        List<Category> cs=catagoryService.getAllCatagory();
        model.addAttribute("cs",cs);
        return "admin/listCategory";
    }

    @RequestMapping("delete_catagory")
    public String deleteCatagory(Model model,String id){
        List<Category> cs=catagoryService.getAllCatagory();
        model.addAttribute("cs",cs);
        return "admin/listCategory";
    }
}
