package com.pichincha.backend.test.repository;

import com.pichincha.backend.test.model.Account;
import com.pichincha.backend.test.model.Transaction;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {


}
