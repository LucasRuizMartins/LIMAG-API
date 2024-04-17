package com.limag.sistema_limag.controllers;

import com.limag.sistema_limag.dto.EmployeeDTO;
import com.limag.sistema_limag.dto.PurchaserDTO;
import com.limag.sistema_limag.services.PurchaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/compradores")
public class PurchaserController {

    @Autowired
    private PurchaserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PurchaserDTO> findById(@PathVariable Long id) {
        PurchaserDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }


    @GetMapping("/regular")
    public ResponseEntity<Page<PurchaserDTO>> findAll(
            @RequestParam(name = "name", defaultValue = "") String name,
            Pageable pageable) {
        Page<PurchaserDTO> dto = service.findAll(name, pageable);
        return ResponseEntity.ok(dto);
    }


    @PostMapping
    public ResponseEntity<PurchaserDTO> insert(@RequestBody PurchaserDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PurchaserDTO> update(@PathVariable Long id,  @RequestBody PurchaserDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



    // ------ Purchaser For Seller

/*

    @GetMapping("/comprador-vendedor")
    public ResponseEntity<Page<PurchaserForSellerDTO>> findAllPurchaseForSeller(
            @RequestParam(name = "name", defaultValue = "") String name,
            Pageable pageable) {
        Page<PurchaserForSellerDTO> dto = service.findAllPurchaserForSeller(name, pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/comprador-vendedor")
    public ResponseEntity<PurchaserForSellerDTO> insertPurchaserForSeller(@RequestBody PurchaserForSellerDTO dto) {
        dto = service.insertPurchaserForSeller(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
*/
}
