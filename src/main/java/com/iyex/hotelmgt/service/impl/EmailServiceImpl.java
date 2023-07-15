package com.iyex.hotelmgt.service.impl;

import com.iyex.hotelmgt.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static com.iyex.hotelmgt.utils.EmailUtil.getUserCreatedEmailMessage;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    public static final String NEW_USER_ACCOUNT_VERIFICATION = "New User Account verification";

    @Value("${spring.mail.verify.host}")
    private String host;
    @Value(("${spring.mail.username}"))
    private String fromEmail;

    private final JavaMailSender mailSender;

    @Override
    public void sendTextMailMessage(String name, String to, String confirmLink){
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
            message.setFrom(fromEmail);
            message.setTo(to);
            message.setText(getUserCreatedEmailMessage(name,host,confirmLink));
            mailSender.send(message);
        }catch (Exception exc){
            throw new RuntimeException(exc.getMessage());
        }
    }

    @Override
    public void sendMimeMessageWithAttachment(String name, String to, String confirmLink) {

    }

    @Override
    public void sendMimeMessageWithEmbeddedFiles(String name, String to, String confirmLink) {

    }

    @Override
    public void sendHtmlEmail(String name, String to, String confirmLink) {

    }

    @Override
    public void sendHtmlEmailWithEmbeddedFiles(String name, String to, String confirmLink) {

    }

}
