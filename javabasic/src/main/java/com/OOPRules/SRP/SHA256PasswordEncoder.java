package com.OOPRules.SRP;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.stereotype.Component;

@Component
public class SHA256PasswordEncoder implements PasswordEncoder{
    private final static String SHA_256 = "SHA-256";

    @Override
    public String encryptPassword(final String pw){
        final MessageDigest digest;
        try {
            digest = MessageDigest.getInstance(SHA_256);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException();
        }

        final byte[] encodeHash = digest.digest(pw.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encodeHash);
    }

    private String bytesToHex(byte[] encodeHash) {
        final StringBuilder hexString = new StringBuilder(2 * encodeHash.length);

        for(final byte hash : encodeHash){
            final String hex = Integer.toHexString(0xff & hash);
            if(hex.length() == 1){
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
