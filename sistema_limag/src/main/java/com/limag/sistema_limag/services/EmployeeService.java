package com.limag.sistema_limag.services;

import com.limag.sistema_limag.dto.EmployeeDTO;
import com.limag.sistema_limag.entities.Employee;

import com.limag.sistema_limag.repositories.EmployeeRepository;
import com.limag.sistema_limag.services.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional(readOnly = true)
    public EmployeeDTO findById(Long id) {
        Employee employee = repository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Colaborador não encontrado"));
        return new EmployeeDTO(employee);
    }


}
