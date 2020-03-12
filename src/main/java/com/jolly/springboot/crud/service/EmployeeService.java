package com.jolly.springboot.crud.service;

import com.jolly.springboot.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee employee);

    void deleteById(int theId);


}
