package com.iyex.hotelmgt.service;

public interface EmailService {
    void sendTextMailMessage(String name, String to, String confirmLink);
    void sendMimeMessageWithAttachment(String name, String to, String confirmLink);
    void sendMimeMessageWithEmbeddedFiles(String name, String to, String confirmLink);
    void sendHtmlEmail(String name, String to, String confirmLink);
    void sendHtmlEmailWithEmbeddedFiles(String name, String to, String confirmLink);
}
