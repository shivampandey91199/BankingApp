package com.service.IMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.Entity.Account;
import com.dto.AccountDto;
import com.mapper.AccountMapper;
import com.repository.AccountRepository;
import com.service.AccountService;

public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {

		Account account = AccountMapper.mapToAcount(accountDto);
		Account saveAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(saveAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {

		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist!!"));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto Deposit(Long id, double amount) {

		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist!!"));

		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account account2 = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(account2);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist!!"));

		if (account.getBalance() < amount) {
			throw new RuntimeException("Insuffient amount");
		}

		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account save = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(save);
	}

	@Override
	public List<AccountDto> getAllAccount() {
		List<Account> accounts = accountRepository.findAll();
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist!!"));
  accountRepository.delete(account);	
	}

}
	