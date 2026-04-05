package com.ltc.bankapp.dto.transaction;

import com.ltc.bankapp.model.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDto {

    private Long id;
    private Double amount;
    private Type type;
    private LocalDate transactionDate;
    private Long accountId;

}