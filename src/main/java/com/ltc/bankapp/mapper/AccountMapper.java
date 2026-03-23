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

    public AccountResponseDto toDto(Account account) {

        if (account == null){
            return null;
        }

        return new AccountResponseDto(
                account.getId(),
                account.getAccountNumber(),
                account.getBalance(),
                account.getCurrency(),
                account.getCustomer().getId()
        );
    }

    public void updateEntity(AccountResponseDto accountResponseDto, Account account, Customer customer){

        if (account == null || customer == null ||
                accountResponseDto == null){
            return;
        }

        account.setAccountNumber(accountResponseDto.getAccountNumber());
        account.setBalance(accountResponseDto.getBalance());
        account.setCurrency(accountResponseDto.getCurrency());
        account.setCustomer(customer);

    }
}