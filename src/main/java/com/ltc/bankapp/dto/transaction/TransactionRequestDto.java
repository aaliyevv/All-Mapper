package com.ltc.bankapp.dto.transaction;

import com.ltc.bankapp.model.enums.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class TransactionRequestDto {

    @NotNull
    @Positive
    private Double amount;

    @NotNull
    private Type type;

    @NotNull
    private Long accountId;

}