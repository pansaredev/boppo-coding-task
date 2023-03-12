package com.boppo.user.codingtask.controller;

import com.boppo.user.codingtask.entity.Employee;
import com.boppo.user.codingtask.entity.User;
import com.boppo.user.codingtask.model.UserModel;
import com.boppo.user.codingtask.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserRegistartionController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String hello(){
        return "Hello world";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel){
        Employee employee = userModel.getEmployee();
        log.info(employee.getOrganisationName());
        User user = userService.registerUser(userModel);

        return "Success";
    }

}
