package com.capg.pbms;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.capg.pbms.entity.Transaction;
import com.capg.pbms.exceptions.AccountNotFoundException;
import com.capg.pbms.service.ITransactionService;

@SpringBootTest
class PecuniaBankManagementSystemApplicationTests {
	
	@Autowired
	ITransactionService transactionService;

	@Test
	void getAllTransactions() {
		
	List<Transaction> transactions =transactionService.getAllTransactions();
	assertNotNull(transactions);
	}
	
	@Test
	void getTransactionById() throws AccountNotFoundException {
		Transaction transaction = transactionService.getTransactionByTransactionId(9102553);
		assertNotNull(transaction);
	}
	
	

}
