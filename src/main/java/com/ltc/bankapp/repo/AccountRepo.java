package com.ltc.bankapp.repo;

import com.ltc.bankapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account,Long> {

    List<Account> findByCustomerId(Long customerId);
    // SELECT * FROM account WHERE customer_id = ?

}