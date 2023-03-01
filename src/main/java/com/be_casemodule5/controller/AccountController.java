package com.be_casemodule5.controller;

import com.be_casemodule5.model.Account;
import com.be_casemodule5.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Account>> findAll(){
        return new ResponseEntity<>(accountService.showAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account){
        accountService.save(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable int id){
        return new ResponseEntity<>(accountService.findById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        accountService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> edit(@RequestBody Account account){
        accountService.save(account);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }
}
