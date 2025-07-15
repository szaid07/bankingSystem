package com.madhyx.accounts.service;

import com.madhyx.accounts.dto.CustomerDto;
import org.springframework.web.bind.annotation.RequestParam;

public interface IAccountService {

    void createAccount(CustomerDto customerDto);

    CustomerDto getAccountDetails(@RequestParam String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(@RequestParam String mobileNumber);
}
