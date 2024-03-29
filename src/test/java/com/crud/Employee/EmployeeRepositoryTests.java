package com.crud.Employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.assertArg;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.crud.Employee.Models.Employee;
import com.crud.Employee.Repositories.EmployeeRepository;

@DataJpaTest
public class EmployeeRepositoryTests {
    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    public void setupTestData() {
        employee = new Employee();
        employee.setFirstName("Employee");
        employee.setSecondName("Test");
        employee.setFirstLastName("L1");
        employee.setSecondLastName("L2");
        employee.setAge(32);
        employee.setEmail("test@example.com");
        employee.setBirthDate(new Date(2024 - 03 - 15));
        employee.setGender("Female");
        employee.setJob("AI Developer");
    }

    @Test
    @DisplayName("JUnit test - Save Operation Employee")
    public void givenEmployeeObject_whenSave_thenReturnSaveEmployee() {
        Employee savedEmployee = employeeRepository.save(employee);

        // Then : Verify the output

        assertNotEquals(savedEmployee, null);
    }
}
