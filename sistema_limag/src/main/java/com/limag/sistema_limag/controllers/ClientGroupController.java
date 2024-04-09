package com.limag.sistema_limag.controllers;

import com.limag.sistema_limag.dto.ClientDTO;
import com.limag.sistema_limag.dto.ClientGroupDTO;
import com.limag.sistema_limag.services.ClientGroupService;
import com.limag.sistema_limag.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/grupo_clientes")
public class ClientGroupController {

    @Autowired
    private ClientGroupService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientGroupDTO> findById(@PathVariable Long id) {
        ClientGroupDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ClientGroupDTO>> findAll(
            @RequestParam(name = "name", defaultValue = "") String name,
            Pageable pageable) {
        Page<ClientGroupDTO> dto = service.findAll(name, pageable);
        return ResponseEntity.ok(dto);
    }


    @PostMapping
    public ResponseEntity<ClientGroupDTO> insert(@RequestBody ClientGroupDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientGroupDTO> update(@PathVariable Long id, @RequestBody ClientGroupDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
