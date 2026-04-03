package com.ltc.bankapp.dto.card;

import com.ltc.bankapp.model.enums.CardType;
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
    private CardType cardType;
    private LocalDate expirationDate;
    private boolean active;
    private Long accountId;

}