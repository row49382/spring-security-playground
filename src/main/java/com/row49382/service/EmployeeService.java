package com.row49382.service;

import com.row49382.entity.Employee;
import com.row49382.exception.EmployeeNotFoundException;
import com.row49382.repository.EmployeeRepository;
import com.row49382.dto.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final ModelMapper mapper;

    public EmployeeService(EmployeeRepository employeeRepo, ModelMapper mapper) {
        this.employeeRepo = employeeRepo;
        this.mapper = mapper;
    }

    public EmployeeResponse getEmployeeById(int id) throws EmployeeNotFoundException {
        Employee employee = this.employeeRepo.findById(id).orElseThrow(EmployeeNotFoundException::new);
        return this.mapper.map(employee, EmployeeResponse.class);
    }

    public EmployeeResponse create(EmployeeResponse employeeRequest) {
        Employee employeeEntity = this.mapper.map(employeeRequest, Employee.class);
        Employee createdEntity = this.employeeRepo.save(employeeEntity);

        return this.mapper.map(createdEntity, EmployeeResponse.class);
    }
}
