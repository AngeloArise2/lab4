package com.lab4.API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.lab4.API.dto.CustomerAddressDTO;
import com.lab4.API.service.CustomerAddressService;

@RestController
@RequestMapping("/customer-addresses")
public class CustomerAddressController {

    private final CustomerAddressService service;

    public CustomerAddressController(CustomerAddressService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerAddressDTO> createCustomerAddress(
            @RequestBody CustomerAddressDTO dto) {

        CustomerAddressDTO created = service.createCustomerAddress(dto);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<CustomerAddressDTO>> getAllCustomerAddresses() {
        return ResponseEntity.ok(service.getAllCustomerAddresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerAddressDTO> getCustomerAddressById(
            @PathVariable Long id) {

        CustomerAddressDTO dto = service.getCustomerAddressById(id);

        if (dto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerAddressDTO> updateCustomerAddress(
            @PathVariable Long id,
            @RequestBody CustomerAddressDTO dto) {

        CustomerAddressDTO updated = service.updateCustomerAddress(id, dto);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }
}
