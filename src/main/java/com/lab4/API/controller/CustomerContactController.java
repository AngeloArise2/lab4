package com.lab4.API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.lab4.API.dto.CustomerContactDTO;
import com.lab4.API.service.CustomerContactService;

@RestController
@RequestMapping("/customer-contacts")
public class CustomerContactController {

    private final CustomerContactService service;

    public CustomerContactController(CustomerContactService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerContactDTO> createCustomerContact(
            @RequestBody CustomerContactDTO dto) {

        CustomerContactDTO created = service.createCustomerContact(dto);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<CustomerContactDTO>> getAllCustomerContacts() {
        return ResponseEntity.ok(service.getAllCustomerContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerContactDTO> getCustomerContactById(
            @PathVariable Long id) {

        CustomerContactDTO dto = service.getCustomerContactById(id);

        if (dto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerContactDTO> updateCustomerContact(
            @PathVariable Long id,
            @RequestBody CustomerContactDTO dto) {

        CustomerContactDTO updated = service.updateCustomerContact(id, dto);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }
}
