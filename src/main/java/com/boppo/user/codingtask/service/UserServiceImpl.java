package com.boppo.user.codingtask.service;

import com.boppo.user.codingtask.entity.Employee;
import com.boppo.user.codingtask.entity.User;
import com.boppo.user.codingtask.model.UserModel;
import com.boppo.user.codingtask.repository.EmployeeRepository;
import com.boppo.user.codingtask.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@Slf4j
public class UserServiceImpl implements UserService, EmployeeService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setEmailId(userModel.getEmailId());
        user.setFirstName(userModel.getFirstName());;
        user.setLastName(userModel.getLastName());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setEmployee(userModel.getEmployee());

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByEmailId(username);
    }

    @Override
    public List<User> getAllUsersByFirstNameAsc(Pageable sort) {
        return userRepository.findAll(sort).getContent();
    }

    @Override
    public List<User> findAllByOrderByLastNameAsc(Pageable sort) {
        return userRepository.findAll(sort).getContent();
    }

    @Override
    public List<User> findAllByOrderByEmailIdAsc(Pageable sort) {
        return userRepository.findAll(sort).getContent();
    }

    @Override
    public List<Employee> findAllByOrderByEmployeeIdAsc(Pageable sort) {
        return employeeRepository.findAll(sort).getContent();
    }

    @Override
    public List<Employee> findAllByOrderByOrganisationNameAsc(Pageable sort) {
        return employeeRepository.findAll(sort).getContent();
    }
}
