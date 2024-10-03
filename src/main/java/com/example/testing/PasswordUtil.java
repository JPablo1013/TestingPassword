package com.example.testing;

public class PasswordUtil {
    public enum Securitylevel{
        WEAK, MEDIUM, STRONG
    }

    public static Securitylevel assessPassword(String password){
       if(password.length() < 8){
           return Securitylevel.WEAK;
       }
       if(password.matches("[a-zA-Z]")){
           return Securitylevel.WEAK;
       }

        return Securitylevel.MEDIUM;
    }
}
