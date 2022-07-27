package com.OOPRules.SRP;

import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SimplePasswordEncoder passwordEncoder;

    public void addUser(final String email, final String pw) {
        // 비밀번호 암호화 처리
//        final StringBuilder sb = new StringBuilder();
//
//        for (byte b : pw.getBytes(StandardCharsets.UTF_8)) {
//            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
//        }
//
//        final String encrytedPassword = sb.toString();

        // 비밀번호 암호화 처리 분리
        final String encrytedPassword = passwordEncoder.encrytPassword(pw);
        final User user = User.builder()
                .email(email)
                .pw(encrytedPassword).build();

        userRepository.save(user);
    }
}
