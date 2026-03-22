package com.ltc.bankapp.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDto {

    private Long id;
    private String accountNumber;
    private Double balance;
    private String currency;
    private Long customerId;

}