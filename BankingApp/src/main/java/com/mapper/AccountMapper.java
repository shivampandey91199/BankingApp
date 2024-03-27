package com.mapper;

import com.Entity.Account;
import com.dto.AccountDto;

public class AccountMapper {

	public static Account mapToAcount(AccountDto accountDto) {
		Account account = new Account(accountDto.getId(), accountDto.getAccountHolderName(), accountDto.getBalance());
		return account;
	}

	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalance());
		 return accountDto;
	}

}
