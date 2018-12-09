package com.java.blood.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private JavaMailSender mailSender;

    public void send(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mocanumadalin1880@gmail.com");
        message.setTo(to);
        message.setSubject("notification");
        message.setText("notification");
        mailSender.send(message);
    }
}