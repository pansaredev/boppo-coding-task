package com.boppo.user.codingtask.controller;

import com.boppo.user.codingtask.entity.Employee;
import com.boppo.user.codingtask.entity.User;
import com.boppo.user.codingtask.service.EmployeeService;
import com.boppo.user.codingtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserListController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        List<User> list = userService.getAllUsers();
        return list;
    }

    @GetMapping("/users/firstname/{pageNumber}")
    public List<User> getAllUsersByFirstNameAsc(@PathVariable("pageNumber") int pageNumber){
         Pageable sortByFirstName = PageRequest.of(
                pageNumber,
                5,
                Sort.by("firstName")
        );
        List<User> list = userService.getAllUsersByFirstNameAsc(sortByFirstName);
        return list;
    }

    @GetMapping("/users/lastname/{pageNumber}")
    public List<User> findAllByOrderByLastNameAsc(@PathVariable("pageNumber") int pageNumber){
        Pageable sortByLastName = PageRequest.of(
                pageNumber,
                5,
                Sort.by("lastName")
        );
        List<User> list = userService.findAllByOrderByLastNameAsc(sortByLastName);
        return list;
    }

    @GetMapping("/users/emailid/{pageNumber}")
    public List<User> findAllByOrderByEmailIdAsc(@PathVariable("pageNumber") int pageNumber){
        Pageable sortByEmail = PageRequest.of(
                pageNumber,
                5,
                Sort.by("emailId")
        );
        List<User> list = userService.findAllByOrderByEmailIdAsc(sortByEmail);
        return list;
    }

    @GetMapping("/users/employeeid/{page}")
    public List<Employee> findAllByOrderByEmployeeIdAsc(@PathVariable("page") int pageNumber){
        Pageable sortByEmployeeId = PageRequest.of(
                pageNumber,
                5,
                Sort.by("employeeId")
        );
        List<Employee> list = employeeService.findAllByOrderByEmployeeIdAsc(sortByEmployeeId);
        return list;
    }

    @GetMapping("/users/organisation/{page}")
    public List<Employee> findAllByOrderByOrganisationNameAsc(@PathVariable("page")int pageNumber){
        Pageable sortByOrg = PageRequest.of(
                pageNumber,
                5,
                Sort.by("organisationName")
        );
        List<Employee> list = employeeService.findAllByOrderByOrganisationNameAsc(sortByOrg);
        return list;
    }

}
