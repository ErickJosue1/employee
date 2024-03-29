package com.crud.Employee.Mapper;

import com.crud.Employee.Dto.EmployeeDto;
import com.crud.Employee.Models.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getSecondName(),
            employee.getFirstLastName(),
            employee.getSecondLastName(),
            employee.getEmail(),
            employee.getAge(),
            employee.getGender(),
            employee.getBirthDate(),
            employee.getJob()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employee) {
        return new Employee(
            employee.getId(),
            employee.getFirstName(),
            employee.getSecondName(),
            employee.getFirstLastName(),
            employee.getSecondLastName(),
            employee.getEmail(),
            employee.getAge(),
            employee.getGender(),
            employee.getBirthDate(),
            employee.getJob()
        );
    }
}
