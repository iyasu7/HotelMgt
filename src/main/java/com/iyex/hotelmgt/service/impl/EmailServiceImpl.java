package com.iyex.hotelmgt.service.impl;

import com.iyex.hotelmgt.domain.Booking;
import com.iyex.hotelmgt.service.EmailService;
import jakarta.activation.DataHandler;
import jakarta.mail.BodyPart;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.util.ByteArrayDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.util.Map;

import static com.iyex.hotelmgt.utils.EmailUtil.*;
import static java.util.Objects.requireNonNull;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    public static final String NEW_USER_ACCOUNT_VERIFICATION = "New User Account verification";
    public static final String UTF_8_ENCODING = "UTF-8";
    public static final String TEXT_HTML_ENCODING = "Text/html";

    @Value("${spring.mail.verify.host}")
    private String host;

    @Value(("${spring.mail.username}"))
    private String fromEmail;

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Override
    @Async
    public void sendTextMailMessage(String name, String to, String confirmLink) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
            message.setFrom(fromEmail);
            message.setTo(to);
            message.setText(getUserCreatedEmailMessage(name, host, confirmLink));
            mailSender.send(message);
        } catch (Exception exc) {
            throw new RuntimeException(exc.getMessage());
        }
    }
    @Override
    @Async
    public void sendLessThanThreeHoursLeftNotification(Booking booking) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("Less than three Hours lefts for Booking to Expire");
            message.setFrom(fromEmail);
            message.setTo(booking.getUser().getUsername());
            message.setText(getLessThanThreeHoursEmailMessage(booking));
            mailSender.send(message);
        } catch (Exception exc) {
            throw new RuntimeException(exc.getMessage());
        }
    }


    @Override
    @Async
    public void sendMimeMessageWithAttachment(String name, String to, String confirmLink) {
        try {

            EmailMessageStarter emailStarter = getEmailMessageStarter(NEW_USER_ACCOUNT_VERIFICATION,to);
            emailStarter.messageHelper().setText(getUserCreatedEmailMessage(name, host, confirmLink));

            //attachments
            FileSystemResource file1 = new FileSystemResource(new File(System.getProperty("user.home") + "/OneDrive/Pictures/black-lion.jpg"));
            FileSystemResource file2 = new FileSystemResource(new File(System.getProperty("user.home") + "/OneDrive/Pictures/2022ChevroletCamaro-exterior-01.jpg"));
            emailStarter.messageHelper().addAttachment(requireNonNull(file1.getFilename()), file1);
            emailStarter.messageHelper().addAttachment(requireNonNull(file2.getFilename()), file2);

            mailSender.send(emailStarter.message());
        } catch (Exception exc) {
            throw new RuntimeException(exc.getMessage());
        }
    }

    @Override
    @Async
    public void sendMimeMessageWithEmbeddedFiles(String name, String to, String confirmLink) {
        try {
            EmailMessageStarter emailStarter = getEmailMessageStarter(NEW_USER_ACCOUNT_VERIFICATION,to);
            emailStarter.messageHelper().setText(getUserCreatedEmailMessage(name, host, confirmLink));
            //attachments
//            FileSystemResource photo = new FileSystemResource(new File(System.getProperty("user.home") + "/OneDrive/Pictures/DV/C.jpg"));
            FileSystemResource file = new FileSystemResource(new File(System.getProperty("user.home") + "/OneDrive/Pictures/A-GUIDE-TO-UHRS-1.pdf"));

            ClassPathResource photo = new ClassPathResource("logo/zuro_logo_with_city-BG.png");
//            ClassPathResource file = new ClassPathResource("email/confirmation/Confirmation and Instructions _ Official U.S. Department of State Visa Appointment Service _ Ethiopia _ English.pdf");

            emailStarter.messageHelper().addInline(getContentId(photo.getFile().getName()), photo);
            emailStarter.messageHelper().addInline(getContentId(file.getFile().getName()), file);

            mailSender.send(emailStarter.message());
        } catch (Exception exc) {

            throw new RuntimeException(exc.getMessage());
        }
    }

    private EmailMessageStarter getEmailMessageStarter(String subject, String to) throws MessagingException {
        MimeMessage message = getMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, UTF_8_ENCODING);
        messageHelper.setPriority(1);
        messageHelper.setSubject(subject);
        messageHelper.setFrom(fromEmail);
        messageHelper.setTo(to);
//        messageHelper.setText(getUserCreatedEmailMessage(name, host, confirmLink));
        return new EmailMessageStarter(message, messageHelper);
    }

    private record EmailMessageStarter(MimeMessage message, MimeMessageHelper messageHelper) {
    }

    @Override
    @Async
    public void sendHtmlEmail(String name, String to, String confirmLink) {
        try {
            Context context = new Context();
            context.setVariables(Map.of("name",name,"confirmLink",gerVerificationUrl(host,confirmLink)));
            String text = templateEngine.process("signupemailtemplate",context);

            EmailMessageStarter emailStarter = getEmailMessageStarter(NEW_USER_ACCOUNT_VERIFICATION,to);
            emailStarter.messageHelper().setText(text,true);


            mailSender.send(emailStarter.message());
        } catch (Exception exc) {

            throw new RuntimeException(exc.getMessage());
        }
    }
    @Override
    @Async
    public void sendReceiptByEmail(Booking booking) {
        try {
            Context context = new Context();
            context.setVariable("booking",booking);
            String text = templateEngine.process("BookingReceipt",context);

            EmailMessageStarter emailStarter = getEmailMessageStarter("Booking Receipt at "+booking.getHotel().getHotelName().toUpperCase(),booking.getUser().getUsername());
            emailStarter.messageHelper().setText(text,true);

            mailSender.send(emailStarter.message());

        } catch (Exception exc) {
            throw new RuntimeException(exc.getMessage());
        }
    }

    @Override
    @Async
    public void sendHtmlEmailWithEmbeddedFiles(String name, String to, String confirmLink) {
        try {
            EmailMessageStarter emailStarter = getEmailMessageStarter(NEW_USER_ACCOUNT_VERIFICATION, to);

            // Process the Thymeleaf template
            Context context = new Context();
            context.setVariables(Map.of("name", name, "confirmLink", gerVerificationUrl(host, confirmLink)));
            String text = templateEngine.process("signupemailtemplate", context);

            // Create the MimeMultipart for the email
            MimeMultipart mimeMultipart = new MimeMultipart("related");

            // Add the HTML body part
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(text, TEXT_HTML_ENCODING);
            mimeMultipart.addBodyPart(messageBodyPart);

            // Add the logo image as an embedded file
            BodyPart logoBodyPart = new MimeBodyPart();
            ClassPathResource logoResource = new ClassPathResource("logo/zuro_logo.ico");
            logoBodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(logoResource.getInputStream(), "image/x-icon"))); // Use the correct Content-Type for .ico files
            logoBodyPart.setHeader("Content-ID", "<zurologo>");
            mimeMultipart.addBodyPart(logoBodyPart);

            // Set the MimeMultipart as the message content
            emailStarter.message().setContent(mimeMultipart);

            // Send the email
            mailSender.send(emailStarter.message());
        } catch (Exception exc) {
            throw new RuntimeException(exc.getMessage());
        }
    }


    private MimeMessage getMimeMessage() {
        return mailSender.createMimeMessage();
    }

    private String getContentId(String fileName) {
        return "<"+ requireNonNull(fileName) +">";
    }


}
