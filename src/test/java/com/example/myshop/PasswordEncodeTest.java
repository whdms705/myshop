package com.example.myshop;

import org.junit.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncodeTest {
    @Test
    public void encodingTest() throws  Exception{

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        String encode = passwordEncoder.encode("1234");
        System.out.println(encode);

        //boolean matches = passwordEncoder.matches("1234")

    }


}
