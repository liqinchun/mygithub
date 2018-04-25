package com.diploma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/product")
@Controller
public class ProductController {

    @RequestMapping("detail")
    public String productDetail(Model model){
        return "fore/detail";
    }
}
