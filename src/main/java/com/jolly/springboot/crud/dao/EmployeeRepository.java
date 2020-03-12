package com.jolly.springboot.crud.dao;

import com.jolly.springboot.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    public List<Employee> findAllByOrderByLastNameAsc();

}
