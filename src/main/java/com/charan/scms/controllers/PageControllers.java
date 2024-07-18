package com.charan.scms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageControllers {
    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("name","substring Technologies");
        model.addAttribute("channel","Code with durgesh");
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage(){
        return "about";
    }

    @RequestMapping("/services")
    public  String servicesPage(){
        return "services";
    }
}
