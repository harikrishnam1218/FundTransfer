package com.fund.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fund.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	@Query("from Transaction  where month(transactiondate) =:month and year(transactiondate)=:year")
	List<Transaction> statement(Integer month,Integer year);


}
