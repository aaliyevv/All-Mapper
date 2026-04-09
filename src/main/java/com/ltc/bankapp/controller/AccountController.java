package com.ltc.bankapp.controller;

import com.ltc.bankapp.dto.account.AccountRequestDto;
import com.ltc.bankapp.dto.account.AccountResponseDto;
import com.ltc.bankapp.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity <AccountResponseDto> create(
            @Valid @RequestBody AccountRequestDto accountRequestDto) {

        return ResponseEntity.ok(accountService.create(accountRequestDto));
    }

    @GetMapping
    public ResponseEntity <Page<AccountResponseDto>> getAll(
            @RequestParam(required = false) Long customerId, Pageable pageable) {

        if (customerId != null) {
            return ResponseEntity.ok(accountService.getByCustomerId(customerId, pageable));
        }

        return ResponseEntity.ok(accountService.getAll(pageable));
    }

//    @GetMapping("/customer/{customerId}")
//    public ResponseEntity<Page<AccountResponseDto>> getByCustomerId(@PathVariable Long id, Pageable pageable) {
//
//        return ResponseEntity.ok(
//                accountService.getByCustomerId(id, pageable));
//    }


    @GetMapping("/{id}")
    public ResponseEntity <AccountResponseDto> getById(@PathVariable Long id) {

        return ResponseEntity.ok(accountService.getById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity <AccountResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody AccountRequestDto accountRequestDto) {

        return ResponseEntity.ok(accountService.update(id, accountRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id) {

        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}