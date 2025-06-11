package br.com.erudio.java_springboot_erudio.util;

import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class PasswordUtil {

    private static final PasswordEncoder encoder;

    static {
        Pbkdf2PasswordEncoder pbkdf2Encoder = new Pbkdf2PasswordEncoder(
                "", 8, 185000,
                Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);

        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("pbkdf2", pbkdf2Encoder);

        DelegatingPasswordEncoder delegatingEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
        delegatingEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Encoder);

        encoder = delegatingEncoder;
    }

    public static String hash(String password) {
        return encoder.encode(password);
    }
}
