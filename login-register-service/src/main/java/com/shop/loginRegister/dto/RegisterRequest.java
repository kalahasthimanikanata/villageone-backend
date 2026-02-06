package com.shop.loginRegister.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String companyName;
    private String username;
    private String password;
    private String reEnterPassword;
    private String phone;
    private String email;
    private String address;
    private String pincode;
}
