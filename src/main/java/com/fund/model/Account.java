package com.fund.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aid;
	
	private Long accontNumber;
	
	private Double balance;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uid")
	private User user;
	
	public Long getAid() {
		return aid;
	}
	public void setAid(Long aid) {
		this.aid = aid;
	}
	public Long getAccontNumber() {
		return accontNumber;
	}
	
	public void setAccontNumber(Long accontNumber) {
		this.accontNumber = accontNumber;
	}
	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
}
