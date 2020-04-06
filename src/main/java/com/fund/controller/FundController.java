package com.fund.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fund.exception.DBException;
import com.fund.exception.FundException;
import com.fund.model.CustomerData;
import com.fund.model.Transaction;
import com.fund.model.TransferBalanceRequest;
import com.fund.model.User;
import com.fund.service.FundService;


@RestController
@RequestMapping("fundtransfer/api/")
public class FundController {
	
	@Autowired
	private FundService fundService;
	
	@PostMapping
	public ResponseEntity<Long> registerUser(@RequestBody CustomerData customerData) throws DBException{
		Long accountNumber =	fundService.registerUser(customerData);
		return new ResponseEntity(accountNumber,HttpStatus.OK);
	}
	
	@PostMapping("/transferbalance")
	public ResponseEntity<List<Transaction>> transferBalance(@RequestBody TransferBalanceRequest balanceRequest) throws FundException{
		List<Transaction> transactions=fundService.transferFund(balanceRequest);
		return new ResponseEntity(transactions,HttpStatus.OK);
	}
	@GetMapping("/statement")
	public ResponseEntity<List<Transaction>> getMonthlystatement(@RequestParam("month") Integer month, @RequestParam("year") Integer year ) throws FundException{
		List<Transaction> statement=fundService.getMonthlyStatement(month, year);
		return new ResponseEntity(statement,HttpStatus.OK);
	}
}
