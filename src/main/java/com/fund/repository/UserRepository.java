package com.fund.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fund.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
