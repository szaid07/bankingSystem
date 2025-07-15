package com.madhyx.accounts.service.impl;

import com.madhyx.accounts.constants.AccountsConstants;
import com.madhyx.accounts.dto.CustomerDto;
import com.madhyx.accounts.entity.Accounts;
import com.madhyx.accounts.entity.Customer;
import com.madhyx.accounts.exception.CustomerAlreadyExistsException;
import com.madhyx.accounts.mapper.CustomerMapper;
import com.madhyx.accounts.repository.AccountsRepository;
import com.madhyx.accounts.repository.CustomerRepository;
import com.madhyx.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    /**
     * @param customerDto
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());

        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exists! with given mobile number" + customerDto.getMobileNumber());
        }
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    /**
     * @param customer
     * @return
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId((customer.getCustomerId()));
        long randomAccNumber = 100000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }
}
