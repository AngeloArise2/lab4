package com.lab4.API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.lab4.API.dto.CustomerProofIdDTO;
import com.lab4.API.service.CustomerProofIdService;

@RestController
@RequestMapping("/customer-proof-ids")
public class CustomerProofIdController {

    private final CustomerProofIdService service;

    public CustomerProofIdController(CustomerProofIdService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerProofIdDTO> createCustomerProofId(
            @RequestBody CustomerProofIdDTO dto) {

        CustomerProofIdDTO created = service.createCustomerProofId(dto);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<CustomerProofIdDTO>> getAllCustomerProofIds() {
        return ResponseEntity.ok(service.getAllCustomerProofIds());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerProofIdDTO> getCustomerProofIdById(
            @PathVariable Long id) {

        CustomerProofIdDTO dto = service.getCustomerProofIdById(id);

        if (dto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerProofIdDTO> updateCustomerProofId(
            @PathVariable Long id,
            @RequestBody CustomerProofIdDTO dto) {

        CustomerProofIdDTO updated = service.updateCustomerProofId(id, dto);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }
}
