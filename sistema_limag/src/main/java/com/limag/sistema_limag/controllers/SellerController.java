package com.limag.sistema_limag.controllers;

import com.limag.sistema_limag.dto.EmployeeDTO;
import com.limag.sistema_limag.dto.SellerDTO;
import com.limag.sistema_limag.services.EmployeeService;
import com.limag.sistema_limag.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vendedores")
public class SellerController {

    @Autowired
    private SellerService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<SellerDTO> findById(@PathVariable Long id) {
        SellerDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

}
