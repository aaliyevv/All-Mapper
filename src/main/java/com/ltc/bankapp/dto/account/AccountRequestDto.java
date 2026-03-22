package com.ltc.bankapp.dto.account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AccountRequestDto {

    @NotBlank
    private String accountNumber;

    @NotNull
    @Positive
    private Double balance;

    @NotBlank
    private String currency;

    @NotNull
    private Long customerId;  //We only need the id not full customer

}