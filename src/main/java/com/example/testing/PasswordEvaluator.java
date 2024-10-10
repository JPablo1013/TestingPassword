package com.example.testing;

public interface PasswordEvaluator {
    PasswordUtil.Securitylevel assessPassword(String password);
}
