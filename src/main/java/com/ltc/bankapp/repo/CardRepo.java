package com.ltc.bankapp.repo;

import com.ltc.bankapp.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepo extends JpaRepository<Card,Long> {

    List<Card> findByAccountId(Long accountId);
}