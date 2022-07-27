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
    private final PasswordChecker passwordChecker;

    public void addUser(final String email, final String pw) {
        // 비밀번호 암호화 처리 분리
        final String encrytedPassword = passwordEncoder.encryptPassword(pw);
        final User user = User.builder()
                .email(email)
                .pw(encrytedPassword).build();

        userRepository.save(user);
    }

    public void updateUser(final String email, final String pw){
        User user = userRepository.getUserInfo(email);
        // 디비에서 가져오지 않아서.. 인코딩 수기로..
        user.pw = passwordEncoder.encryptPassword(user.pw);
        // 비밀번화 확인
        if(email.equals(user.email) && passwordChecker.isCorrectPassword(user.pw, pw)){
            User updatedUser = User.builder()
                            .email(email)
                            .pw(passwordEncoder.encryptPassword(pw))
                            .build();
            userRepository.save(updatedUser);
        }else{
            System.out.println("잘못된 패스워드 입력!");
        }
    }
}
