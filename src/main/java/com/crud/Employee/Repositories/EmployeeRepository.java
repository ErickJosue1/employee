package com.crud.Employee.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.Employee.Models.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

}
