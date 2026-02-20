package com.lab4.API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.lab4.API.dto.CustomerNameDTO;
import com.lab4.API.service.CustomerNameService;

@RestController
@RequestMapping("/customer-names")
public class CustomerNameController {

    private final CustomerNameService service;

    public CustomerNameController(CustomerNameService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerNameDTO> createCustomerName(
            @RequestBody CustomerNameDTO dto) {

        CustomerNameDTO created = service.createCustomerName(dto);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<CustomerNameDTO>> getAllCustomerNames() {
        return ResponseEntity.ok(service.getAllCustomerNames());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerNameDTO> getCustomerNameById(
            @PathVariable Long id) {

        CustomerNameDTO dto = service.getCustomerNameById(id);

        if (dto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerNameDTO> updateCustomerName(
            @PathVariable Long id,
            @RequestBody CustomerNameDTO dto) {

        CustomerNameDTO updated = service.updateCustomerName(id, dto);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }
}
