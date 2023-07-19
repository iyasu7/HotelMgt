package com.iyex.hotelmgt.service;

import com.iyex.hotelmgt.domain.Booking;
import org.springframework.scheduling.annotation.Async;

public interface EmailService {
    void sendTextMailMessage(String name, String to, String confirmLink);

    @Async
    void sendLessThanThreeHoursLeftNotification(Booking booking);

    void sendMimeMessageWithAttachment(String name, String to, String confirmLink);
    void sendMimeMessageWithEmbeddedFiles(String name, String to, String confirmLink);
    void sendHtmlEmail(String name, String to, String confirmLink);

    @Async
    void sendReceiptByEmail(Booking booking);

    void sendHtmlEmailWithEmbeddedFiles(String name, String to, String confirmLink);
}
