package com.lab4.API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.lab4.API.dto.CustomerClassificationDTO;
import com.lab4.API.service.CustomerClassificationService;

@RestController
@RequestMapping("/customer-classifications")
public class CustomerClassificationController {

    private final CustomerClassificationService service;

    public CustomerClassificationController(CustomerClassificationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerClassificationDTO> createCustomerClassification(
            @RequestBody CustomerClassificationDTO dto) {

        CustomerClassificationDTO created = service.createCustomerClassification(dto);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<CustomerClassificationDTO>> getAllCustomerClassifications() {
        return ResponseEntity.ok(service.getAllCustomerClassifications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerClassificationDTO> getCustomerClassificationById(
            @PathVariable Long id) {

        CustomerClassificationDTO dto = service.getCustomerClassificationById(id);

        if (dto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerClassificationDTO> updateCustomerClassification(
            @PathVariable Long id,
            @RequestBody CustomerClassificationDTO dto) {

        CustomerClassificationDTO updated = service.updateCustomerClassification(id, dto);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }
}
