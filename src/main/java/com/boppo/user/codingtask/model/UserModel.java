package com.boppo.user.codingtask.model;

import com.boppo.user.codingtask.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private Employee employee;
}
