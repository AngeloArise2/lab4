package com.lab4.API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.lab4.API.dto.CustomerDetailsDTO;
import com.lab4.API.service.CustomerDetailsService;

@RestController
@RequestMapping("/customers")
public class CustomerDetailsController {

    private final CustomerDetailsService service;

    public CustomerDetailsController(CustomerDetailsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerDetailsDTO> createCustomer(
            @RequestBody CustomerDetailsDTO dto) {

        CustomerDetailsDTO created = service.createCustomer(dto);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDetailsDTO>> getAllCustomers() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetailsDTO> getCustomerById(
            @PathVariable String id) {

        CustomerDetailsDTO dto = service.getCustomerById(id);

        if (dto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDetailsDTO> updateCustomer(
            @PathVariable String id,
            @RequestBody CustomerDetailsDTO dto) {

        CustomerDetailsDTO updated = service.updateCustomer(id, dto);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }
}
