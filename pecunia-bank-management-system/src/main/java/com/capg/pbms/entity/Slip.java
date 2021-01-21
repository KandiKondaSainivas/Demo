package com.capg.pbms.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "slip_tbl")

public class Slip {
	
	@Id
	@SequenceGenerator(name="seq", initialValue=100000, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private int slipId;
    private long accountNum;
    private String slipHolderName;
    private String slipType;
    private Double amount;
    private LocalDate slipIssueDate;
	public Slip(int slipId, long accountNum, String slipHolderName, String slipType, Double amount, LocalDate slipIssueDate) {
		super();
		this.slipId = slipId;
		this.accountNum = accountNum;
		this.slipHolderName = slipHolderName;
		this.slipType = slipType;
		this.amount = amount;
		this.slipIssueDate = slipIssueDate;
	}
	public Slip() {
		super();
		
	}
	public int getSlipId() {
		return slipId;
	}
	public void setSlipId(int slipId) {
		this.slipId = slipId;
	}
	public long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(long accountNum) {
		this.accountNum = accountNum;
	}
	public String getSlipHolderName() {
		return slipHolderName;
	}
	public void setSlipHolderName(String slipHolderName) {
		this.slipHolderName = slipHolderName;
	}
	public String getSlipType() {
		return slipType;
	}
	public void setSlipType(String slipType) {
		this.slipType = slipType;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDate getSlipIssueDate() {
		return slipIssueDate;
	}
	public void setSlipIssueDate(LocalDate slipIssueDate) {
		this.slipIssueDate = slipIssueDate;
	}
    
    

}
