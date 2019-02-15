package com.clive.service;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryptionTest {

    @Test
    public void shouldEncryptPassword() {
        String password = "password";

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(password);

        System.out.println(encryptedPassword);
    }
}
