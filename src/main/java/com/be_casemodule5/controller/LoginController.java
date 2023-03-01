package com.be_casemodule5.controller;

import com.be_casemodule5.model.Account;
import com.be_casemodule5.model.dto.AccountToken;
import com.be_casemodule5.service.AccountService;
import com.be_casemodule5.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    AccountService accountService;
    @PostMapping
    public AccountToken login(@RequestBody Account account) {
        // tạo ra 1 đối tượng xác thực
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword())
        );
        // nơi chứa đối tượng đang đăng nhập
        // truyền đối tượng đăng nhập vào securityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // tạo ra token
        String token = jwtService.createToken(authentication);
        Account account1 = accountService.findAccountByUsername(account.getUsername());
        return new AccountToken(account1.getName(),account1.getUsername(), account1.getPassword(), account1.getPhone(), account1.getAddress(), account1.getAvatar(), account1.getRole(), token);
    }
}
