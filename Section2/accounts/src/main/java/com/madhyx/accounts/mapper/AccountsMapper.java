package com.madhyx.accounts.mapper;

import com.madhyx.accounts.dto.AccountsDto;
import com.madhyx.accounts.entity.Accounts;

public class AccountsMapper {
    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts  accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }
}
