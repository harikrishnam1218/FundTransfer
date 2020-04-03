package com.fund.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fund.exception.DBException;
import com.fund.exception.FundException;
import com.fund.exception.UserNotFoundException;
import com.fund.model.Account;
import com.fund.model.CustomerData;
import com.fund.model.Transaction;
import com.fund.model.TransferBalanceRequest;
import com.fund.model.User;
import com.fund.repository.AccountRepository;
import com.fund.repository.TransactionRepository;
import com.fund.repository.UserRepository;

@Service
public class FundServiceImpl implements FundService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private TransactionRepository transactionRepo;

	@Override
	public Long registerUser(CustomerData data) throws DBException {
		Account accountData=null;
		User userData = userData(data);
		User user=userRepository.save(userData);
		if(Objects.nonNull(user) && Objects.nonNull(user.getUid())) {
			Account account=new Account();
			account.setBalance(data.getBalance());
			account.setAccontNumber(ramdomNumber()); 
			account.setUser(user);
			accountData=accountRepo.save(account);
		if(Objects.isNull(accountData) && Objects.isNull(accountData.getAid())){
			{
				throw new DBException("Account Data not saved..");
			}
		}
		}else {
			throw new DBException("User Data not Saved ...");
		}
		Transaction trasaction=new Transaction(accountData.getBalance(),accountData.getAccontNumber(),new Timestamp(System.currentTimeMillis()));
		trasaction.setMessage(accountData.getBalance()+" has been Credited to "+accountData.getAccontNumber());
		transactionRepo.save(trasaction);
		
		return accountData.getAccontNumber();
	}

	private User userData(CustomerData data) {
		User userData=new User();
		userData.setAadhar(data.getAadhar());
		userData.setAge(data.getAge());
		userData.setFname(data.getFname());
		userData.setGender(data.getGender());
		userData.setLname(data.getLname());
		userData.setPan(data.getPan());
		return userData;
	}
	private Long ramdomNumber() {
		Random rand = new Random();
		long x = (long)(rand.nextDouble()*1000000000000L);
		return x;
	}

	@Override
	public User getUserData(Long uid) throws UserNotFoundException {
		Optional<User> optionalData=userRepository.findById(uid);
		if(!optionalData.isPresent()) {
			throw new UserNotFoundException("UserData not Found ..");
		}
		return optionalData.get();
	}

	@Override
	@Transactional
	public List<Transaction> transferFund(TransferBalanceRequest request) throws FundException {
		
		List<Transaction> transationList= new ArrayList<>();
		
		Long from=request.getFromAccountNumber();
		Long to=request.getToAccountNumber();
		Double transferAmount=request.getAmount();
		
		Account fromAccount=accountRepo.findByAccontNumber(from);
		if(Objects.isNull(fromAccount)){
			throw new FundException("From Account Number is Invalid");
		}
		Account toAccount=accountRepo.findByAccontNumber(to);
		if(Objects.isNull(toAccount)){
			throw new FundException("TO Account Number is Invalid");
		}
		if(fromAccount.getAccontNumber().equals(toAccount.getAccontNumber())){
			throw new FundException("Both From and To accounts are same");
		}
		
		if(fromAccount.getBalance()<=transferAmount) {
			throw new FundException("Insufficient Balance in Account ..");
		}
		
		fromAccount.setBalance(fromAccount.getBalance()-transferAmount);
		toAccount.setBalance(toAccount.getBalance()+transferAmount);
	
		accountRepo.save(fromAccount);
		accountRepo.save(toAccount);
		
		Transaction fromTransaction=new Transaction(transferAmount,fromAccount.getAccontNumber(),new Timestamp(System.currentTimeMillis()));
		fromTransaction.setMessage(transferAmount+" has been Debited from "+fromAccount.getAccontNumber());
		Transaction fromTrans=transactionRepo.save(fromTransaction);
		
		if(Objects.isNull(fromTrans)) {
			throw new FundException("Transaction has been failed ");
		}
		Transaction toTransaction=new Transaction(transferAmount,toAccount.getAccontNumber(),new Timestamp(System.currentTimeMillis()));
		toTransaction.setMessage(transferAmount+" has been Credited to "+toAccount.getAccontNumber());
		Transaction toTrans=transactionRepo.save(toTransaction);
		
		if(Objects.isNull(toTrans)) {
			throw new FundException("Transaction has been failed ");
		}
		transationList.add(fromTrans);
		transationList.add(toTrans);
		
		return transationList;
	}
	
	
}
