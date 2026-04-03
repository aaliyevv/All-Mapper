package com.ltc.bankapp.dto.account;

import com.ltc.bankapp.model.enums.Currency;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;


@Data
public class AccountRequestDto {

    @NotNull
    private Integer accountNumber;

    @NotNull
    @Positive
    private Double balance;

    @NotNull
    private Currency currency;

    @NotNull
    private Long customerId;  //We only need the id not full customer

}