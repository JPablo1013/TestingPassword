package com.example.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilTest {
    private final PasswordEvaluator passwordEvaluator = new PasswordUtil();

    @Test
    public void weak_when_has_less_than_8_letters1() {
        assertEquals(PasswordUtil.Securitylevel.WEAK, passwordEvaluator.assessPassword("1234567"));
    }

    @Test
    public void weak_when_has_less_than_8_letters2() {
        assertEquals(PasswordUtil.Securitylevel.WEAK, passwordEvaluator.assessPassword("Str0ng!Password"));
    }

    @Test
    public void weak_when_has_only_letters() {
        assertEquals(PasswordUtil.Securitylevel.WEAK, passwordEvaluator.assessPassword("abcdefg"));
    }

    @Test
    public void medium_when_has_letters_and_numbers() {
        assertEquals(PasswordUtil.Securitylevel.MEDIUM, passwordEvaluator.assessPassword("abc12345"));
    }

    @Test
    public void strong_when_has_letters_numbers_and_signs() {
        assertEquals(PasswordUtil.Securitylevel.STRONG, passwordEvaluator.assessPassword("abc12345.,"));
    }

    @Test
    public void strong_when_has_letters_numbers_and_signs2() {
        assertEquals(PasswordUtil.Securitylevel.STRONG, passwordEvaluator.assessPassword("P@ssw0rd123!"));
    }
}
