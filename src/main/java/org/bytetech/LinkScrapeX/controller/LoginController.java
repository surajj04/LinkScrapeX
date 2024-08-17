package org.bytetech.LinkScrapeX.controller;

import jakarta.servlet.http.HttpSession;
import org.bytetech.LinkScrapeX.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private HttpSession session;


    @GetMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {

        User user = new User(email, password);
        session.setAttribute("user", user);

        return "upload.html";
    }




}
