package com.diploma.controller;

import com.diploma.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/product")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @RequestMapping("detail")
    public String productDetail(Model model,String productId){
        model.addAttribute("product",productService.getProduct(productId));
        model.addAttribute("history_price",productService.getProductPrice(productId));
        System.out.println("+++++++++"+productId);
        return "fore/detail";
    }
}
