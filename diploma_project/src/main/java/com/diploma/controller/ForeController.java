package com.diploma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
@Controller
public class ForeController {

    @RequestMapping("forehome")
    public String home(Model model){

        return "fore/home";
    }

    /**
     * 主页的搜索
     * @param model
     * @param content
     * @return
     */
    @RequestMapping("foresearch")
    public String search(Model model,String content){


        return "fore/showpage";
    }
}
