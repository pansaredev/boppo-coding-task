package com.boppo.user.codingtask.repository;

import com.boppo.user.codingtask.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailId(String email);

    //Following methods can also be used for sorting

    /*List<User> findAllByOrderByFirstNameAsc();
    List<User> findAllByOrderByLastNameAsc();
    List<User> findAllByOrderByEmailIdAsc();*/
}
