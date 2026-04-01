package com.ltc.bankapp.service;

import com.ltc.bankapp.dto.transaction.TransactionRequestDto;
import com.ltc.bankapp.dto.transaction.TransactionResponseDto;
import com.ltc.bankapp.exception.AccountNotFoundException;
import com.ltc.bankapp.exception.InsufficientBalanceException;
import com.ltc.bankapp.mapper.TransactionMapper;
import com.ltc.bankapp.model.Account;
import com.ltc.bankapp.model.Transaction;
import com.ltc.bankapp.repo.AccountRepo;
import com.ltc.bankapp.repo.TransactionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableArgumentResolver;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepo transactionRepo;
    private final AccountRepo accountRepo;
    private final TransactionMapper transactionMapper;
    private final PageableArgumentResolver pageableArgumentResolver;

    public TransactionResponseDto create(TransactionRequestDto transactionRequestDto) {

        Account account = accountRepo.findById(transactionRequestDto.getAccountId()).orElseThrow(
                () -> new AccountNotFoundException("Account not found" + transactionRequestDto.getAccountId()));

        if (transactionRequestDto.getType().equalsIgnoreCase("DEPOSIT")) {
            account.setBalance(account.getBalance() + transactionRequestDto.getAmount());

        } else if (transactionRequestDto.getType().equalsIgnoreCase("WITHDRAW"))
             { if (account.getBalance() < transactionRequestDto.getAmount()) {
                 throw new InsufficientBalanceException("Insufficient balance");
             }
                account.setBalance(account.getBalance() - transactionRequestDto.getAmount());
            }
        accountRepo.save(account);

        Transaction transaction = transactionMapper.toEntity(transactionRequestDto,  account);
        transactionRepo.save(transaction);

        return transactionMapper.toDto(transaction);
    }

    public Page<TransactionResponseDto> getAll(Pageable pageable) {

        return transactionRepo.findAll(pageable)
                .map(transactionMapper:: toDto);
    }

    
}
