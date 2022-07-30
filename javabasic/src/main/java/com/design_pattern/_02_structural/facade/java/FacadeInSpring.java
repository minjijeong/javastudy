package com.design_pattern._02_structural.facade.java;

import org.springframework.jdbc.datasource.JdbcTransactionObjectSupport;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.jdbc.support.JdbcTransactionManager;

public class FacadeInSpring {
    public static void main(String[] args) {
        // client는 mailsender 인터페이스지만, 실질적으로 사용하는 것은 JavaMailSenderImpl
        // 특정 기술에 종속되지 않는다.
        MailSender mailSender = new JavaMailSenderImpl();

        // jpa, jdbc, hibernate 각각 구현체를 가지고 사용 가능
        PlatformTransactionManager platformTransactionManager = new JdbcTransactionManager();

        // Spring5 이전에는 spring webmvc - servelt 이었다!
        // spring5 이후에는 servelt 아닐수 있다, mono, flux 등 다른 것을 사용할 수 있다.
        // spring mvc 일종의 facade로 볼수 있다. 기술의 독립적인 인터페이스를 쓰도록 설계된다.
    }
}
