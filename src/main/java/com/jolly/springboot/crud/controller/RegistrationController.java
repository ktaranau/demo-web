package com.jolly.springboot.crud.controller;

import com.jolly.springboot.crud.entity.User;
import com.jolly.springboot.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }

    @GetMapping
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") User user, BindingResult result){
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()){
            return "registration";
        }
        userService.save(user);
        return "redirect:/login?r_success";
    }


}
