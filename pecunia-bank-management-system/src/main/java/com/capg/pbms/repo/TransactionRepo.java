package com.capg.pbms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.pbms.entity.BankAccountDetails;
import com.capg.pbms.entity.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>{
	
@Query("From Transaction As transaction where transaction.transactionId=:transactionId")
public Transaction findByTransactionId(@Param("transactionId")int transactionId);

@Query("From BankAccountDetails As account where account.accNumber=:accNumber")
public BankAccountDetails findByAccountId(@Param("accNumber")long accNumber);


}
