package com.design_pattern._02_structural.facade;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    EmailSettings emailSettings;

    public EmailSender(EmailSettings emailSettings){
        this.emailSettings = emailSettings;
    }

    public void sendEmail(EmailMessage emailMessage){
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", emailSettings.getHost());
        properties.setProperty("mail.smtp.port", emailSettings.getPort());

        // 메일 서버 세팅
        Session session = Session.getDefaultInstance(properties);

        try {
            // 메일 메세지 세팅
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailMessage.getFrom()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailMessage.getTo()));
            message.setSubject(emailMessage.getSubject());
            message.setText(emailMessage.getText());

            // 메일 전송
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
