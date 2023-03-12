package com.boppo.user.codingtask.service;

import com.boppo.user.codingtask.entity.Employee;
import com.boppo.user.codingtask.entity.User;
import com.boppo.user.codingtask.model.UserModel;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User registerUser(UserModel userModel);

    List<User> getAllUsers();

    User getUserByUsername(String username);

    List<User> getAllUsersByFirstNameAsc(Pageable sort);

    List<User> findAllByOrderByLastNameAsc(Pageable sort);

    List<User> findAllByOrderByEmailIdAsc(Pageable sort);

    //List<Employee> findAllByOrderByEmployeeIdAsc();

    //List<User> findByOrgOrderByOrgAsc();

}
