package com.OOPRules.SRP;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SimplePasswordEncoder passwordEncoder;

    public void addUser(final String email, final String pw) {
        // 비밀번호 암호화 처리 분리
        final String encrytedPassword = passwordEncoder.encryptPassword(pw);
        final User user = User.builder()
                .email(email)
                .pw(encrytedPassword).build();

        userRepository.save(user);
    }
}
