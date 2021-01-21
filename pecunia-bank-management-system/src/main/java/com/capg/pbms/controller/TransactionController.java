package com.capg.pbms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.pbms.entity.Transaction;
import com.capg.pbms.exceptions.AccountNotFoundException;
import com.capg.pbms.exceptions.InsufficientBalanceException;
import com.capg.pbms.service.ITransactionService;

@RestController
@RequestMapping("/transaction")
@CrossOrigin("*")
public class TransactionController {

	@Autowired
	ITransactionService service;
	@PostMapping("/debitwithslip/{accNumber}/amount/{amount}")
	public Transaction debitUsingSlip(@PathVariable("accNumber") long accNumber, @PathVariable("amount") double amount,

			@RequestBody Transaction transaction) throws InsufficientBalanceException, AccountNotFoundException {

		return service.debitUsingSlip(accNumber, amount, transaction);
	}

	@PostMapping("/creditwithslip/{accNumber}/amount/{amount}")
	public Transaction creditUsingSlip(@PathVariable("accNumber") long accNumber, @PathVariable("amount") double amount,

			@RequestBody Transaction transaction) throws InsufficientBalanceException, AccountNotFoundException {
		return service.creditUsingSlip(accNumber, amount, transaction);
	}

	

	@GetMapping("/getAll")
	public List<Transaction> getAllTransaction() {
		return service.getAllTransactions();
	}

	@GetMapping("/trans/{transId}")
	public Transaction findByTransactionId(@PathVariable("transId") int transId) throws AccountNotFoundException {

		return service.getTransactionByTransactionId(transId);

	}

	@GetMapping("/trans/getalltransactions/{accNumber}")
	public List<Transaction> getAllTransactions(@PathVariable ("accNumber") long accNumber)
	{
		return service.getAllTransactionByAccountNumber(accNumber);
	}
	
}
