package com.ltc.bankapp.controller;

import com.ltc.bankapp.dto.transaction.TransactionRequestDto;
import com.ltc.bankapp.dto.transaction.TransactionResponseDto;
import com.ltc.bankapp.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity <TransactionResponseDto> create(
            @Valid @RequestBody TransactionRequestDto transactionRequestDto){

        return ResponseEntity.ok(transactionService.create(transactionRequestDto));
    }