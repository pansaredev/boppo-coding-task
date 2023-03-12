package com.boppo.user.codingtask.repository;

import com.boppo.user.codingtask.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByOrderByEmployeeIdAsc();

    List<Employee> findAllByOrderByOrganisationNameAsc();

}
