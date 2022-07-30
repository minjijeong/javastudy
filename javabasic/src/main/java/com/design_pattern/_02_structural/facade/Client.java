package com.design_pattern._02_structural.facade;

public class Client {
    public static void main(String[] args) {
        String from = "test@kakao.com";
        String to = "test@gmail.com";
        String host = "smtp.kakao.com";
        String port = "465";

        // 이메일 세팅
        EmailSettings emailSettings = new EmailSettings();
        emailSettings.setHost(host);
        emailSettings.setPort(port);

        EmailSender emailSender = new EmailSender(emailSettings);

        // 이메일 내용 세팅
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setFrom(from);
        emailMessage.setTo(to);
        emailMessage.setSubject("Test Mail from Java Program");
        emailMessage.setText("이메일 입니다!!! \n");
        // 이메일 전송
        emailSender.sendEmail(emailMessage);
    }
}
