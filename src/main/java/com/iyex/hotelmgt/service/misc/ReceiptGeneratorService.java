package com.iyex.hotelmgt.service.misc;

import com.iyex.hotelmgt.domain.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;

@Service
@RequiredArgsConstructor
public class ReceiptGeneratorService {

    private final TemplateEngine templateEngine;

    public byte[] generateReceiptPDF(Booking booking) {
        Context context = new Context();
        context.setVariable("booking", booking);

        String htmlContent = templateEngine.process("BookingReceipt", context);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        try {
            renderer.createPDF(outputStream);
            renderer.finishPDF();
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
        }

        return outputStream.toByteArray();
    }
}

