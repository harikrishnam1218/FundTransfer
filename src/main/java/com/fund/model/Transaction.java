package com.fund.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long transactionId;

  /*  @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aid")
    private Account account;
*/
    private Double transactionAmount;

    private Timestamp transactiondate;
    
    private Long accountnumber;
    
    private String message;
    
    

	public Long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(Long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	
	public Timestamp getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(Timestamp transactiondate) {
		this.transactiondate = transactiondate;
	}

/*	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Transaction(Account account, Double transactionAmount, Timestamp transactionDateTime) {
		super();
		this.account = account;
		this.transactionAmount = transactionAmount;
		this.transactionDateTime = transactionDateTime;
	}*/

	
	public Transaction() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Transaction(Double transactionAmount,Long accountnumber, Timestamp transactiondate,String message ) {
		super();
		this.transactionAmount = transactionAmount;
		this.accountnumber = accountnumber;
		this.transactiondate = transactiondate;
		this.message=message;
		
	}
	
	public Transaction(Double transactionAmount,Long accountnumber, Timestamp transactiondate) {
		super();
		this.transactionAmount = transactionAmount;
		this.accountnumber = accountnumber;
		this.transactiondate = transactiondate;
	}
    

}