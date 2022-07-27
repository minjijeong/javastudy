package com.OOPRules.srp_ocp_Isp;

import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Component;

@Component
public class SimplePasswordEncoder implements PasswordEncoder, PasswordChecker{

    @Override
    public String encryptPassword(final String pw){
        final StringBuilder sb = new StringBuilder();

        for(byte b : pw.getBytes(StandardCharsets.UTF_8)){
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    @Override
    public boolean isCorrectPassword(String rawPw, String pw) {
        final String encryptedPw = encryptPassword(rawPw);
        return encryptedPw.equals(pw);
    }
}
