package com.ltc.bankapp.repo;

import com.ltc.bankapp.model.Account;
import com.ltc.bankapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Long> {

    @Query("SELECT a FROM Account a WHERE a.balance > :amount")
    List<Account> findRichAccounts(Double amount);

}