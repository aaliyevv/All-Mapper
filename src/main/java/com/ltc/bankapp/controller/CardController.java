package com.ltc.bankapp.controller;

import com.ltc.bankapp.dto.card.CardRequestDto;
import com.ltc.bankapp.dto.card.CardResponseDto;
import com.ltc.bankapp.model.Card;
import com.ltc.bankapp.service.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CardResponseDto> create(
            @Valid @RequestBody CardRequestDto cardRequestDto) {

        return ResponseEntity.ok(cardService.create(cardRequestDto));
    }

    @GetMapping
    public ResponseEntity <Page<CardResponseDto>> getAll(
            @RequestBody(required = false) Long accountId, Pageable pageable) {

        if (accountId != null) {
            return ResponseEntity.ok(cardService.getByAccountId(accountId, pageable));
        }

        return ResponseEntity.ok(cardService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardResponseDto> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(cardService.getById(id));
    }


    @PutMapping("/{id}/deactivate")
    public ResponseEntity<CardResponseDto> update(
            @PathVariable Long id){

        return ResponseEntity.ok(cardService.deactivate(id));
    }

//    @PutMapping("/{id}/activate")
//    public ResponseEntity<CardResponseDto> update(
//            @PathVariable Long id) {
//
//        return ResponseEntity.ok(cardService.activate(id));
//    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        cardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}