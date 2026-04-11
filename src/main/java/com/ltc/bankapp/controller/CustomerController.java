package com.ltc.bankapp.controller;

import com.ltc.bankapp.dto.customer.CustomerRequestDto;
import com.ltc.bankapp.dto.customer.CustomerResponseDto;
import com.ltc.bankapp.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDto> create(
            @Valid @RequestBody CustomerRequestDto customerRequestDto) {

        return ResponseEntity.ok(customerService.create((customerRequestDto)));
    }

    @GetMapping
    public ResponseEntity<Page<CustomerResponseDto>> getAll(Pageable pageable) {

        return ResponseEntity.ok(customerService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getById(@PathVariable Long id) {

        return ResponseEntity.ok(customerService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody CustomerRequestDto customerRequestDto) {

        return ResponseEntity.ok(customerService.update(id, customerRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}