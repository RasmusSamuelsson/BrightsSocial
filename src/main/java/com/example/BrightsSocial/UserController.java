package com.example.BrightsSocial;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    @Autowired
    public UserRepository userRepository;
    String rightUser = "admin";
    String rightPassword = "123456";

    @GetMapping("/")
    public String home (Model model){
        return "home";

    }

    @PostMapping("/")
    public String login (HttpSession session, @RequestParam String username, @RequestParam String password) {

        if (username.equals(rightUser) && password.equals(rightPassword)) {
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            return "logintemporary";            // change the name of the template
        }
        return "/";

    }
    @GetMapping("/login")
    public String login2 (HttpSession session) {
        String username = (String)session.getAttribute("username");
        String password = (String)session.getAttribute("password");
        if (username != null && password != null) {
            return "logintemporary";
        }
        return "redirect:/";
    }

    @GetMapping ("/register")
    public String registerReturn () {
        return "register";
    }
    @PostMapping("/register")
    public String registerUser (@ModelAttribute Model model, User user) {
        model.addAttribute("user", user);
        userRepository.addUser(user);
        System.out.println(user);
        return "logintemporary";
    }

}
