package com.ltc.bankapp.dto.transaction;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class TransactionRequestDto {

    @NotNull
    @Positive
    private Double amount;

    @NotBlank
    private String type;

    @NotNull
    private Long accountId;

}