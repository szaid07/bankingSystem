package com.madhyx.accounts.repository;

import com.madhyx.accounts.entity.Accounts;
import com.madhyx.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    
}
