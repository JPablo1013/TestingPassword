package com.example.testing;

public class PasswordUtil implements PasswordEvaluator {
    public enum Securitylevel {
        WEAK, MEDIUM, STRONG
    }

    @Override
    public Securitylevel assessPassword(String password) {
        // Evaluar si la longitud es menor que 8 caracteres
        if (password.length() < 8) {
            return Securitylevel.WEAK;
        }
        // Evaluar si solo tiene letras
        if (password.matches("[a-zA-Z]+")) {
            return Securitylevel.WEAK;
        }
        // Evaluar si tiene letras y números, pero no caracteres especiales
        if (password.matches("(?=.*[0-9])[a-zA-Z0-9]+")) {
            return Securitylevel.MEDIUM;
        }
        // Evaluar si tiene letras, números y caracteres especiales
        if (password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).+")) {
            return Securitylevel.STRONG;
        }

        return Securitylevel.MEDIUM; // Valor por defecto
    }
}
