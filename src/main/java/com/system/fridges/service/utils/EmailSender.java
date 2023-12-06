package com.system.fridges.service.utils;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.util.Properties;

public class EmailSender {

    private static final  String SUBJECT = "Program controlling fridges";

    private final JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

    public void sendEmail(String to, String body) throws MessagingException {
        connectEmailSender();

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(to);
        helper.setSubject(SUBJECT);
        helper.setText(body);

        javaMailSender.send(mimeMessage);
    }

    private void connectEmailSender() {
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("ukrainigromadanin284@gmail.com");
        javaMailSender.setPassword("mmniqeveixmprktj");
        Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.smtp.starttls.enable", "true");
    }
}
