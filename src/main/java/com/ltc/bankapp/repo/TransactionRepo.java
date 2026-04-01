package com.ltc.bankapp.repo;

import com.ltc.bankapp.dto.transaction.TransactionResponseDto;
import com.ltc.bankapp.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction,Long> {

    Page<Transaction> findByAccountId(Long accountId,  Pageable pageable);

}