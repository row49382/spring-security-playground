package com.row49382.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends Exception {
    @Serial
    private static final long serialVersionUID = -3291021754124388488L;

    public EmployeeNotFoundException() {
        super("Employee Not Found");
    }
}
