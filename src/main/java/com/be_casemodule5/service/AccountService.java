package com.be_casemodule5.service;


import com.be_casemodule5.model.Account;
import com.be_casemodule5.model.Role;
import com.be_casemodule5.repo.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AccountService implements UserDetailsService {

    @Autowired
    IAccountRepo iAccountRepo;
    public List<Account> showAll() {
        return (List<Account>) iAccountRepo.findAll();
    }
    public void save(Account account) {
        iAccountRepo.save(account);
    }
    public void delete(int id) {
        iAccountRepo.deleteById(id);
    }

    public Account findById(int id) {
        return iAccountRepo.findById(id).get();
    }

    public Account findAccountById(int id) {
        return iAccountRepo.findById(id).get();
    }

    public Account findAccountByUsername(String username) {
        Account account = iAccountRepo.findAccountByUsername(username);
        return account;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccountRepo.findAccountByUsername(username);
        List<Role> roles = new ArrayList<>();
        roles.add(account.getRole());
        return new User(account.getUsername(), account.getPassword(), roles);

    }

}
