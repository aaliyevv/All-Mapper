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
}