package com.pichincha.backend.test.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.backend.test.model.Transaction;

@Repository
public interface TransactionRepositpory extends JpaRepository<Transaction, Long> {

	Set<Transaction> findByAccountId(Long accountId);

}
