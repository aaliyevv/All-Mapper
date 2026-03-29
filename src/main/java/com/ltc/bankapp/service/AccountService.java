package com.ltc.bankapp.service;

import com.ltc.bankapp.dto.account.AccountRequestDto;
import com.ltc.bankapp.dto.account.AccountResponseDto;
import com.ltc.bankapp.dto.customer.CustomerRequestDto;
import com.ltc.bankapp.dto.customer.CustomerResponseDto;
import com.ltc.bankapp.exception.CustomerNotFoundException;
import com.ltc.bankapp.mapper.AccountMapper;
import com.ltc.bankapp.model.Account;
import com.ltc.bankapp.model.Customer;
import com.ltc.bankapp.repo.AccountRepo;
import com.ltc.bankapp.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepo accountRepo;
    private final AccountMapper accountMapper;
    private final CustomerRepo customerRepo;

    public AccountResponseDto create(AccountRequestDto accountRequestDto){

        Customer customer = customerRepo.findById(accountRequestDto.getCustomerId()).orElseThrow(
                () -> new CustomerNotFoundException("Customer not found:" + accountRequestDto.getCustomerId()));

        Account account = accountMapper.toEntity(accountRequestDto, customer);
        accountRepo.save(account);
        return accountMapper.toDto(account);

    }

}
