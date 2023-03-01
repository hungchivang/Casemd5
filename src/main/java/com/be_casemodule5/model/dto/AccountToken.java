package com.be_casemodule5.model.dto;

import com.be_casemodule5.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountToken {
    private String name;
    private String username;
    private String password;
    private String phone;
    private String address;
    private String avatar;
    private Role role;
    private String token;
}
