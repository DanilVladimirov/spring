package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/login")
    public String getRegistration(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "login";
    }

    @PostMapping("/login")
    public String postRegistration(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {
        String page = "login";
        UserModel user = userRepo.findByusername(username);
        if (user == null) {
            model.addAttribute("errorMsg", "user not found");
            model.addAttribute("isError", true);
            model.addAttribute("url", "login");
            return page;
        }
        if (password.equals(user.getPassword())) {
            model.addAttribute("hello", "hello " + username + "!");
            return "success";
        } else {
            model.addAttribute("errorMsg", "username or password invalid");
            model.addAttribute("isError", true);
            model.addAttribute("url", "login");
            return page;
        }
    }
}
