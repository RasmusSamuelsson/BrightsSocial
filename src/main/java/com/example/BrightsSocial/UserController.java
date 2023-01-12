package com.example.BrightsSocial;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public MessageRepository messageRepository;

    String rightUser = "admin";
    String rightPassword = "123456";

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        boolean loggedIn = Boolean.TRUE == session.getAttribute("loggedIn");
        if (loggedIn) {
            return "redirect:/myprofile";
        }
        return "home";

    }

    @PostMapping("/")
    public String login(HttpSession session, @RequestParam String username, @RequestParam String password) {
       List<People> allPeople = (List<People>) userRepository.findAll();
        for (People people : allPeople) {
            if (username.equals(people.getUsername().toLowerCase()) && password.equals(people.getPasscode())) {
                String cap = username.substring(0, 1).toUpperCase() + username.substring(1);
                session.setAttribute("username", cap);
                session.setAttribute("password", password);
                session.setAttribute("loggedIn", Boolean.TRUE);
                session.setAttribute("user", people);
                return "redirect:/myprofile";            // change the name of the template
            }

        }
        return "redirect:/";

    }

    @GetMapping("/login")
    public String login2(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        String user = (String) session.getAttribute("user");


        if (username != null && password != null) {
            return "redirect:/myprofile";
        }

        return "redirect:/login";
    }

    @GetMapping("/myprofile")
    public String name(HttpSession session, Model model) {
        List<People> allPeople = (List<People>) userRepository.findAll();
        List<Message> allMessages = messageRepository.getMessages();
        List<People> usersToShow = new ArrayList<>();
        String username = (String) session.getAttribute("username");
        for (People people : allPeople) {
            if (!people.getUsername().equals(username)) {
                usersToShow.add(people);
            }
        }


        model.addAttribute("users", usersToShow);
        model.addAttribute("messages", allMessages);
        return "myprofile";

    }

    @PostMapping("/myprofile")
    public String sendMessage(HttpSession session, @RequestParam String message) {
        String name = (String) session.getAttribute("username");
        LocalDateTime time = LocalDateTime.now();
        messageRepository.add(new Message(message, name, time));


        return "redirect:/myprofile";

    }

    @GetMapping("/register")
    public String registerReturn(Model model) {
        model.addAttribute("user", new People());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute People people, BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        model.addAttribute("user", people);
        session.setAttribute("user", people);
        session.setAttribute("username", people.getUsername());
        session.setAttribute("loggedIn", Boolean.TRUE);
        userRepository.save(people);
        System.out.println(people);
        return "redirect:/myprofile";
    }

    @GetMapping("/profile/{username}")
    public String userProfile(Model model, @PathVariable String username, HttpSession session) {
        People people = userRepository.findByUsername(username);
        model.addAttribute("user", people);
        if (session.getAttribute("username").equals(username)) {
            return "redirect:/myprofile";
        }
        return "userProfile";
    }

    @GetMapping("/editprofile")
    public String editProfile(HttpSession session) {
        return "editProfile";
    }

    @PostMapping("/editprofile")
    public String saveEditProfile(HttpSession session, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String city, @RequestParam String presentation, @RequestParam String password) {
        People people = (People) session.getAttribute("user");
        people.setFirstName(firstName);
        people.setLastName(lastName);
        people.setCity(city);
        people.setPresentation(presentation);
        people.setPasscode(password);
        return "redirect:/myprofile";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
