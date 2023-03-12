package com.boppo.user.codingtask.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;
    private String firstName;
    private String lastName;
    private String emailId;
    @Column(length = 60)
    private String password;

    public User(String firstName, String lastName, String emailId, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
    }

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "employeeId"
    )
    private Employee employee;

}
