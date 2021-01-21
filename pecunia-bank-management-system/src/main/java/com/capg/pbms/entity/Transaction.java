package com.capg.pbms.entity;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="transaction_tbl")
public class Transaction {

	@Id
	private int transactionId;
	private long transAccountNumber;
	private double currentBalance;
	private double transactionAmount;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDateTime transactionDate;
	private double transClosingBalance;

	@OneToOne(cascade = { CascadeType.ALL })
	private Slip slipDetails;

	public Transaction() {

	}

	public long getTransAccountNumber() {
		return transAccountNumber;
	}

	public void setTransAccountNumber(long transAccountNumber) {
		this.transAccountNumber = transAccountNumber;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransClosingBalance() {
		return transClosingBalance;
	}

	public void setTransClosingBalance(double transClosingBalance) {
		this.transClosingBalance = transClosingBalance;
	}

	

	public Slip getSlipDetails() {
		return slipDetails;
	}

	public void setSlipDetails(Slip slipDetails) {
		this.slipDetails = slipDetails;
	}

	public Transaction(int transactionId, long transAccountNumber, double currentBalance, double transactionAmount,
			LocalDateTime transactionDate, double transClosingBalance,  Slip slipDetails) {
		super();
		this.transactionId = transactionId;
		this.transAccountNumber = transAccountNumber;
		this.currentBalance = currentBalance;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.transClosingBalance = transClosingBalance;
		this.slipDetails = slipDetails;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transAccountNumber=" + transAccountNumber
				+ ", currentBalance=" + currentBalance + ", transactionAmount=" + transactionAmount
				+ ", transactionDate=" + transactionDate + ", transClosingBalance=" + transClosingBalance
				+ ", chequeDetails=" +  ", slipDetails=" + slipDetails + "]";
	}


}