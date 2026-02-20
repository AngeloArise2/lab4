package com.lab4.API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.lab4.API.dto.CustomerIdentificationDTO;
import com.lab4.API.service.CustomerIdentificationService;

@RestController
@RequestMapping("/customer-identifications")
public class CustomerIdentificationController {

    private final CustomerIdentificationService service;

    public CustomerIdentificationController(CustomerIdentificationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerIdentificationDTO> createCustomerIdentification(
            @RequestBody CustomerIdentificationDTO dto) {

        CustomerIdentificationDTO created = service.createCustomerIdentification(dto);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<CustomerIdentificationDTO>> getAllCustomerIdentifications() {
        return ResponseEntity.ok(service.getAllCustomerIdentifications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerIdentificationDTO> getCustomerIdentificationById(
            @PathVariable Long id) {

        CustomerIdentificationDTO dto = service.getCustomerIdentificationById(id);

        if (dto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerIdentificationDTO> updateCustomerIdentification(
            @PathVariable Long id,
            @RequestBody CustomerIdentificationDTO dto) {

        CustomerIdentificationDTO updated = service.updateCustomerIdentification(id, dto);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }
}
