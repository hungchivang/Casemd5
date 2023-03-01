package com.be_casemodule5.repo;

import com.be_casemodule5.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface IAccountRepo extends CrudRepository<Account,Integer> {
    Account findAccountByUsername(String username);
}
