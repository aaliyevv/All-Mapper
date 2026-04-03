package com.ltc.bankapp.model;

import com.ltc.bankapp.model.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private Type type;
    private LocalDate transactionDate;

    @ManyToOne(fetch = FetchType.EAGER) // when we run we can see JOIN in temrinal.
    @JoinColumn(name = "account_id")
    private Account account;

}