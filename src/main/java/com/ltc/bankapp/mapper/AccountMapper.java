package com.ltc.bankapp.mapper;

import com.ltc.bankapp.dto.account.AccountRequestDto;
import com.ltc.bankapp.dto.account.AccountResponseDto;
import com.ltc.bankapp.model.Account;
import com.ltc.bankapp.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account toEntity(AccountRequestDto accountRequestDto, Customer customer){

        if (accountRequestDto == null || customer == null){
            return null;
        }

        Account account = new Account();

        account.setAccountNumber(accountRequestDto.getAccountNumber());
        account.setBalance(accountRequestDto.getBalance());
        account.setCurrency(accountRequestDto.getCurrency());
        account.setCustomer(customer);

        return account;
    }

    