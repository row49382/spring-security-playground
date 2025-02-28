package com.row49382.controller;

import com.row49382.dto.EmployeeResponse;
import com.row49382.exception.EmployeeNotFoundException;
import com.row49382.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id)
            throws EmployeeNotFoundException {
        EmployeeResponse employee = this.employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @PostMapping("/employee")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeResponse request) {
        EmployeeResponse createdEmployee = this.employeeService.create(request);
        return ResponseEntity.ofNullable(createdEmployee);
    }
}
