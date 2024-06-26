package com.limag.sistema_limag.controllers;

import com.limag.sistema_limag.dto.EmployeeDTO;
import com.limag.sistema_limag.dto.SellerDTO;
import com.limag.sistema_limag.services.EmployeeService;
import com.limag.sistema_limag.services.SellerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @GetMapping
    public ResponseEntity<Page<SellerDTO>> findAll(
            @RequestParam(name = "name", defaultValue = "") String name,
            Pageable pageable) {
        Page<SellerDTO> dto = service.findAll(name, pageable);
        return ResponseEntity.ok(dto);
    }


    @PostMapping
    public ResponseEntity<SellerDTO> insert(@Valid @RequestBody SellerDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<SellerDTO> update(@PathVariable Long id, @Valid @RequestBody SellerDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
