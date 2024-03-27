package com.service;

import java.util.List;

import com.dto.AccountDto;

public interface AccountService {

	AccountDto createAccount(AccountDto accountDto);

	AccountDto getAccountById(Long id);

	AccountDto Deposit(Long id, double amount);

	AccountDto withdraw(Long id, double amount);

	List<AccountDto> getAllAccount();
	
	void deleteAccount(Long id);	

}
