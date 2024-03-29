package com.crud.Employee.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Employee.Dto.EmployeeDto;
import com.crud.Employee.Services.EmployeeService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<EmployeeDto>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id) {
        return new ResponseEntity<EmployeeDto>(employeeService.getEmployeeDto(id), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return new ResponseEntity<List<EmployeeDto>>(employeeService.getAllEmployees(), HttpStatus.FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {

        return new ResponseEntity<String>(employeeService.deleteEmployee(id), HttpStatus.FOUND);
    }

    @PutMapping("path/{id}")
    public ResponseEntity<EmployeeDto> putMethodName(@PathVariable Long id, @RequestBody EmployeeDto entity) {
        return new ResponseEntity<EmployeeDto>(employeeService.updateEmployee(id, entity), HttpStatus.CREATED);
    }
}
