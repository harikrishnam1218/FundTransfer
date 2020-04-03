package com.fund.service;

import java.util.List;

import com.fund.exception.DBException;
import com.fund.exception.FundException;
import com.fund.exception.UserNotFoundException;
import com.fund.model.CustomerData;
import com.fund.model.Transaction;
import com.fund.model.TransferBalanceRequest;
import com.fund.model.User;

public interface FundService {
	
 Long registerUser(CustomerData customer) throws DBException;
 
 User getUserData(Long uid) throws UserNotFoundException;
 
 List<Transaction> transferFund(TransferBalanceRequest request) throws FundException;
	
}
