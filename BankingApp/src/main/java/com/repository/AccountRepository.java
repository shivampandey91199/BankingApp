package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long >{

}
