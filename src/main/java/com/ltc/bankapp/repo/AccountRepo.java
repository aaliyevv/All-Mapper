package com.ltc.bankapp.repo;

import com.ltc.bankapp.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account,Long> {

    Page<Account> findByCustomerId(Long customerId,  Pageable pageable);
    // SELECT * FROM account WHERE customer_id = ?

}