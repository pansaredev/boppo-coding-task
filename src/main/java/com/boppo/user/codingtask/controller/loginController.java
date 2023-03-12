package com.boppo.user.codingtask.controller;

import com.boppo.user.codingtask.entity.User;
import com.boppo.user.codingtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user = userService.getUserByUsername(userName);

        return "Welcome "+ user.getFirstName();
    }

}
