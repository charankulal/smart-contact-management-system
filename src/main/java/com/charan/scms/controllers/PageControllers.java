package com.charan.scms.controllers;

import com.charan.scms.entities.User;
import com.charan.scms.forms.UserForm;
import com.charan.scms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageControllers {

    @Autowired
    private UserService userService;
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
    @GetMapping("/contact")
    public  String contactPage(){
        return "contact";
    }

    @GetMapping("/login")
    public  String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public  String registerPage(Model model){
        UserForm userForm= new UserForm();
        model.addAttribute("userForm", userForm);
        userForm.setAbout("This is a sample");
        return "register";
    }

    // Processing register
    @PostMapping( "/do-register")
    public String processRegister(@ModelAttribute UserForm userForm){

        User user = User.builder().name(userForm.getName()).email(userForm.getEmail()).password(userForm.getPassword()).about(userForm.getAbout()).phoneNumber(userForm.getPhoneNumber()).profilePic("D:\\Docs\\Github_Profile.jpg").build();

        User saveUser=userService.saveUser(user);
        System.out.println(saveUser.toString());

        return "redirect:/register";
    }
}
