package com.example.BrightsSocial;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    public UserRepository userRepository;
    String rightUser = "admin";
    String rightPassword = "123456";

    @GetMapping("/")
    public String home (HttpSession session, Model model){
        boolean loggedIn = Boolean.TRUE == session.getAttribute("loggedIn");
        if(loggedIn){
            return "redirect:/myprofile";
        }
        return "home";

    }

    @PostMapping("/")
    public String login (HttpSession session, @RequestParam String username, @RequestParam String password) {
        for (User user : userRepository.users) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                session.setAttribute("loggedIn", Boolean.TRUE);
                session.setAttribute("user", user);
                return "redirect:/myprofile";            // change the name of the template
        }

        }
        return "redirect:/";

    }
    @GetMapping("/login")
    public String login2 (HttpSession session, Model model) {
        String username = (String)session.getAttribute("username");
        String password = (String)session.getAttribute("password");
        String user = (String)session.getAttribute("user");


        if (username != null && password != null) {
            return "redirect:/myprofile";
        }

        return "redirect:/login";
    }

   @GetMapping("/myprofile")
    public String name (HttpSession session, Model model) {
       List<User> allUsers = userRepository.getUsers();
       List<User> usersToShow = new ArrayList<>();
       String username = (String)session.getAttribute("username");
       for (User user : allUsers) {
           if(!user.getUsername().equals(username)){
               usersToShow.add(user);
           }
       }


       model.addAttribute("users", usersToShow);
       return "myprofile";

    }

    @GetMapping ("/register")
    public String registerReturn (Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String registerUser (@Valid @ModelAttribute User user,BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        model.addAttribute("user", user);
        session.setAttribute("user", user);
        session.setAttribute("username", user.getUsername());
        session.setAttribute("loggedIn", Boolean.TRUE);
        userRepository.addUser(user);
        System.out.println(user);
        System.out.println(userRepository.getUsers());
        return "redirect:/myprofile";
    }

 @GetMapping("/profile/{username}")
    public String userProfile (Model model, @PathVariable String username){
        User user = userRepository.getUser(username);
        model.addAttribute("user", user);
        return "userProfile";
 }
 @GetMapping("/editprofile")
 public String editProfile(HttpSession session ) {
        return "editProfile";
 }

 @PostMapping("/editprofile")
 public String saveEditProfile(HttpSession session, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String city, @RequestParam String presentation, @RequestParam String password){
        User user = (User)session.getAttribute("user");
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setCity(city);
        user.setPresentation(presentation);
        user.setPassword(password);
        return "redirect:/myprofile";
 }





    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return  "redirect:/";
    }

}
