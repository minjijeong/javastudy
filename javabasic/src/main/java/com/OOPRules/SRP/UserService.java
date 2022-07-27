package com.OOPRules.SRP;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    /**
     * PasswordEncoder 인터페이스로 추상화하여 의존성을 낮춘다.
     * PasswordEncoder를 구현한 구현체로 언제든지 바꿔어도 해당 서비스는 변경이 없다.
     */
    private final PasswordEncoder passwordEncoder;

    public void addUser(final String email, final String pw) {
        // 비밀번호 암호화 처리 분리
        final String encrytedPassword = passwordEncoder.encryptPassword(pw);
        final User user = User.builder()
                .email(email)
                .pw(encrytedPassword).build();

        userRepository.save(user);
    }
}
