package com.OOPRules.srp_ocp_Isp;

public interface PasswordChecker {

    /**
     * 비밀번호 암호환 데이타와 동일한지 체크
     */
    boolean isCorrectPassword(final String rawPw, final String pw);
}
