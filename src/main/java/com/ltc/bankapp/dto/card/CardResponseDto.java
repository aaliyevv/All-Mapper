package com.ltc.bankapp.dto.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardResponseDto {

    private Long id;
    private String cardNumber;
    private String cardType;
    private LocalDate expirationDate;
    private boolean active = true;
    private Long accountId;

}