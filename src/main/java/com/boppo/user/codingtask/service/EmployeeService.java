package com.boppo.user.codingtask.service;

import com.boppo.user.codingtask.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> findAllByOrderByEmployeeIdAsc(Pageable sort);

    List<Employee> findAllByOrderByOrganisationNameAsc(Pageable sort);

}
