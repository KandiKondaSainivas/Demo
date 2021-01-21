package com.capg.pbms.service;


import java.util.List;


import com.capg.pbms.entity.Transaction;
import com.capg.pbms.exceptions.AccountNotFoundException;

import com.capg.pbms.exceptions.InsufficientBalanceException;

public interface ITransactionService {
	
public List<Transaction> getAllTransactions();

public List<Transaction> getAllTransactionByAccountNumber(long accNumber);

public Transaction getTransactionByTransactionId (int transactionId) throws AccountNotFoundException;


Transaction debitUsingSlip(long accNumber, double amount, Transaction transaction)throws InsufficientBalanceException, AccountNotFoundException;

Transaction creditUsingSlip(long accNumber, double amount, Transaction transaction) throws InsufficientBalanceException, AccountNotFoundException;

	
}
