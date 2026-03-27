package com.ltc.bankapp.mapper;

import com.ltc.bankapp.dto.transaction.TransactionRequestDto;
import com.ltc.bankapp.dto.transaction.TransactionResponseDto;
import com.ltc.bankapp.model.Account;
import com.ltc.bankapp.model.Transaction;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TransactionMapper {

    public Transaction toEntity(TransactionRequestDto transactionRequestDto,  Account account){

        if (transactionRequestDto ==  null || account==null){
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setAmount(transactionRequestDto.getAmount());
        transaction.setType(transactionRequestDto.getType());
        transaction.setTransactionDate(LocalDate.now()); //   System should generate it, not user send
        transaction.setAccount(account);