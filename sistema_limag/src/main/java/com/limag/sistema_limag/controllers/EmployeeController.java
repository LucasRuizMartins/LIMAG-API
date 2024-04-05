package com.limag.sistema_limag.controllers;

import com.limag.sistema_limag.dto.EmployeeDTO;
import com.limag.sistema_limag.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/funcionarios")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
        EmployeeDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

}
