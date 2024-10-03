package com.example.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilTest  {
    @Test
    public void weak_when_has_less_than_8_letters(){
        assertEquals(PasswordUtil.Securitylevel.WEAK, PasswordUtil.assessPassword("1234567"));
    }

    @Test
    public void weak_when_has_only_letters(){
        assertEquals(PasswordUtil.Securitylevel.WEAK, PasswordUtil.assessPassword("abcdefg"));
    }

    @Test
    public void weak_when_has_letters_and_numbers(){
        assertEquals(PasswordUtil.Securitylevel.MEDIUM, PasswordUtil.assessPassword("abcdefg"));
    }

}