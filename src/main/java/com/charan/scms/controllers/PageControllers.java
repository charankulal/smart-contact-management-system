package com.charan.scms.controllers;

import com.charan.scms.entities.User;
import com.charan.scms.forms.UserForm;
import com.charan.scms.helpers.Message;
import com.charan.scms.helpers.MessageType;
import com.charan.scms.services.UserService;
import jakarta.servlet.http.HttpSession;
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
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session){

        User user= new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("D:\\Docs\\Github_Profile.jpg");
        user.setName(userForm.getName());

        User saveUser=userService.saveUser(user);

        Message message=Message.builder().content("Registration Successful").type(MessageType.green).build();

        session.setAttribute("message",message);

        return "redirect:/register";
    }
}
