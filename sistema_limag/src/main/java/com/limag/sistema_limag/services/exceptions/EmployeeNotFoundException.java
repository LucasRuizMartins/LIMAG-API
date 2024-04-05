package com.limag.sistema_limag.services.exceptions;

public class EmployeeNotFoundException extends  RuntimeException{

    public EmployeeNotFoundException(String msg) {
        super(msg);
    }
}
