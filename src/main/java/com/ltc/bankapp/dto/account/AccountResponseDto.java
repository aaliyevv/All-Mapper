package com.ltc.bankapp.dto.account;

import com.ltc.bankapp.model.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDto {

    private Long id;
    private Integer accountNumber;
    private Double balance;
    private Currency currency;
    private Long customerId;

}