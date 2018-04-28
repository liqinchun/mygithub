package com.diploma.controller;

import com.diploma.mysql.model.ProductDetail;
import com.diploma.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RequestMapping("/home")
@Controller
public class ForeController {
    @Autowired
    private ProductService productService;

    @RequestMapping("forehome")
    public String home(Model model){

        return "fore/home";
    }

    /**
     * 主页的搜索
     * @param model
     * @param keyword
     * @return
     */
    @RequestMapping("foresearch")
    public String search(Model model,@RequestParam("keyword") String keyword){

        List<ProductDetail> Productlist=productService.findProductByKeyWord(keyword);

        model.addAttribute("allProduct",Productlist);
        return "fore/showpage";
    }
}
