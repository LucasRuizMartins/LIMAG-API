package com.limag.sistema_limag.controllers;

import com.limag.sistema_limag.dto.PurchaserDTO;
import com.limag.sistema_limag.dto.PurchaserForSellerDTO;
import com.limag.sistema_limag.services.PurchaserForSellerService;
import com.limag.sistema_limag.services.PurchaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/comprador_vendedor")
public class PurchaserForSellerController {

    @Autowired
    private PurchaserForSellerService service;

    @GetMapping("/{id}")
    public ResponseEntity<PurchaserForSellerDTO> findPurchaserForSellerById(@PathVariable Long id) {
        PurchaserForSellerDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<PurchaserForSellerDTO>> findAllPurchaseForSeller(Pageable pageable) {
        Page<PurchaserForSellerDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PurchaserForSellerDTO> insert(@RequestBody PurchaserForSellerDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PurchaserForSellerDTO> update(@PathVariable Long id,  @RequestBody PurchaserForSellerDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
