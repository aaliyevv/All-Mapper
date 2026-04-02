package com.ltc.bankapp.service;

import com.ltc.bankapp.dto.card.CardRequestDto;
import com.ltc.bankapp.dto.card.CardResponseDto;
import com.ltc.bankapp.exception.AccountNotFoundException;
import com.ltc.bankapp.exception.CardNotFoundException;
import com.ltc.bankapp.mapper.CardMapper;
import com.ltc.bankapp.model.Account;
import com.ltc.bankapp.model.Card;
import com.ltc.bankapp.repo.AccountRepo;
import com.ltc.bankapp.repo.CardRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.ResourceTransactionManager;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepo cardRepo;
    private final AccountRepo accountRepo;
    private final CardMapper cardMapper;
    private final ResourceTransactionManager resourceTransactionManager;

    public CardResponseDto create(CardRequestDto cardRequestDto){

        Account account =accountRepo.findById(cardRequestDto.getAccountId()).orElseThrow(
                ()-> new AccountNotFoundException("Account not found" + cardRequestDto.getAccountId()));

        Card card = cardMapper.toEntity(cardRequestDto,account);
        cardRepo.save(card);

        return cardMapper.toDto(card);
    }

    public Page<CardResponseDto> getAll(Pageable pageable){

        return cardRepo.findAll(pageable)
                .map(cardMapper::toDto);
    }

    public CardResponseDto findById(Long id){

        Card card = cardRepo.findById(id).orElseThrow(
                () -> new CardNotFoundException("Card not found" + id));

        return cardMapper.toDto(card);
    }