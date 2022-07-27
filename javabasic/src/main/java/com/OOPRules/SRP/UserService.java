package com.OOPRules.SRP;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    /**
     * Encoder가 바뀜에 따라 기존 UserService의 소스가 변경되어야 하는 것은
     * 개방폐쇄원칙에서 수정에 대해서는 닫혀있어야 한다는 원칙을 위배
     */
    private final SHA256PasswordEncoder passwordEncoder;

    public void addUser(final String email, final String pw) {
        // 비밀번호 암호화 처리 분리
        final String encrytedPassword = passwordEncoder.encryptPassword(pw);
        final User user = User.builder()
                .email(email)
                .pw(encrytedPassword).build();

        userRepository.save(user);
    }
}
