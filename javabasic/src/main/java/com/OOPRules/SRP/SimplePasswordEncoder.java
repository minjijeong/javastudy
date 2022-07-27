package com.OOPRules.SRP;

import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Component;

@Component
public class SimplePasswordEncoder {
    public String encryptPassword(final String pw){
        final StringBuilder sb = new StringBuilder();

        for(byte b : pw.getBytes(StandardCharsets.UTF_8)){
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}
