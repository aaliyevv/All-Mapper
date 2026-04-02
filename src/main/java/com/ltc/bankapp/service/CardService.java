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