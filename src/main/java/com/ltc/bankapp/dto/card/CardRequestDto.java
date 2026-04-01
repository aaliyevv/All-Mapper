package com.ltc.bankapp.dto.card;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CardRequestDto {

    @NotBlank
    private String cardNumber;

    @NotNull
    private String cardType;

    @NotNull
    private LocalDate expirationDate;

    @NotNull
    private Long accountId;

}