package com.crud.Employee.Services;

import org.springframework.stereotype.Service;

import com.crud.Employee.Dto.EmployeeDto;
import com.crud.Employee.Exceptions.NotFoundException;
import com.crud.Employee.Mapper.EmployeeMapper;
import com.crud.Employee.Models.Employee;
import com.crud.Employee.Repositories.EmployeeRepository;

import lombok.AllArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        if (employee == null) {
            return null;
        }

        Employee newEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(newEmployee);
    }

    @SuppressWarnings("null")
    public EmployeeDto getEmployeeDto(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found by using the given " + id + " Id"));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    public String deleteEmployee(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found by using the given " + id + " Id"));

        employeeRepository.delete(employee);

        return "Employee deleted";
    }
    
    @SuppressWarnings("null")
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found by using the given " + id + " Id"));
        
        
        employeeRepository.save(employee);
    
        return null;
    }
}
