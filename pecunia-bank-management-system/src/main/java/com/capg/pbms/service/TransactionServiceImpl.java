package com.capg.pbms.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.pbms.entity.BankAccountDetails;
import com.capg.pbms.entity.Transaction;
import com.capg.pbms.exceptions.AccountNotFoundException;
import com.capg.pbms.exceptions.InsufficientBalanceException;
import com.capg.pbms.repo.TransactionRepo;
@Service
@Transactional
public class TransactionServiceImpl implements ITransactionService {
	@Autowired
	TransactionRepo transactionRepo;
	

	@Override
	public List<Transaction> getAllTransactions() {
		
		return transactionRepo.findAll();
	}

	@Override
	public List<Transaction> getAllTransactionByAccountNumber(long accNumber) {
		List<Transaction> transactions = transactionRepo.findAll();
		List<Transaction> transactionList = new ArrayList<Transaction>();
		for(Transaction transaction: transactions) {
			if(transaction.getTransAccountNumber()==accNumber) {
				transactionList.add(transaction);
			}
	}
		return transactionList;
	

	}


	@Override
	public Transaction getTransactionByTransactionId(int transactionId) throws AccountNotFoundException {
	 Transaction transaction = transactionRepo.findByTransactionId(transactionId);
	 if (transaction == null) {
			throw new AccountNotFoundException("transactionId not found");
		}
		return transaction;
		
	}


	
	@Override
	public Transaction debitUsingSlip(long accNumber, double amount, Transaction transaction) throws InsufficientBalanceException, AccountNotFoundException {
		
		BankAccountDetails bankDetails= transactionRepo.findByAccountId(accNumber);
		if (bankDetails==null) {
			throw new AccountNotFoundException("account number doesn't exists");
		}
		transaction.setTransAccountNumber(bankDetails.getAccNumber());
		transaction.setCurrentBalance(bankDetails.getAccountBalance());
		if (amount > transaction.getCurrentBalance()) {
			throw new InsufficientBalanceException("Amount less than current balance");
		}
		if (amount< 0) {
			throw new InsufficientBalanceException("Amount should be in positive number");
		}
		transaction.setTransactionId(Integer.parseInt((String.valueOf(Math.abs(new Random().nextLong())).substring(0, 7))));
		transaction.setTransClosingBalance(transaction.getCurrentBalance() - amount);
		transaction.setTransactionAmount(transaction.getCurrentBalance() - transaction.getTransClosingBalance());
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.getSlipDetails().setAccountNum(accNumber);
		transaction.getSlipDetails().setAmount(amount);
		transaction.getSlipDetails().setSlipIssueDate(LocalDate.now());
		bankDetails.setAccountBalance(transaction.getCurrentBalance() - amount);
		bankDetails.setAccountBalance(transaction.getCurrentBalance() - amount);
		return transactionRepo.save(transaction);
		
	}

	@Override
	public Transaction creditUsingSlip(long accNumber, double amount, Transaction transaction) throws InsufficientBalanceException, AccountNotFoundException {
		BankAccountDetails bankDetails= transactionRepo.findByAccountId(accNumber);
		if (bankDetails==null ) {
			throw new AccountNotFoundException("account number doesn't exists");
		}
		if (amount> 200000) {
			throw new InsufficientBalanceException("amount should be less than 2 lakh");
		}
		transaction.setTransAccountNumber(bankDetails.getAccNumber());
		transaction.setCurrentBalance(bankDetails.getAccountBalance());
		transaction.setTransactionId(Integer.parseInt((String.valueOf(Math.abs(new Random().nextLong())).substring(0, 7))));
		transaction.setTransClosingBalance(transaction.getCurrentBalance() + amount);
		transaction.setTransactionAmount(transaction.getTransClosingBalance() - transaction.getCurrentBalance());
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.getSlipDetails().setAccountNum(accNumber);
		transaction.getSlipDetails().setAmount(amount);
		transaction.getSlipDetails().setSlipIssueDate(LocalDate.now());
		bankDetails.setAccountBalance(transaction.getCurrentBalance() + amount);

		bankDetails.setAccountBalance(transaction.getCurrentBalance() +amount);
		return transactionRepo.save(transaction);
		
	}

	
	

	

}
