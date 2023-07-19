package com.iyex.hotelmgt.resource;

import com.iyex.hotelmgt.domain.Booking;
import com.iyex.hotelmgt.service.BookingService;
import com.iyex.hotelmgt.service.misc.ReceiptGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;
    private  final ReceiptGeneratorService receiptGeneratorService;

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id){
        return bookingService.getBookingById(id);
    }

    @GetMapping("{bookingNumber}")
    public Booking getBookingByBookingNumber(@PathVariable String bookingNumber){
        return bookingService.getBookingByBookingNumber(UUID.fromString(bookingNumber));
    }
    @GetMapping("/bookings/{bookingId}/receipt")
    public ResponseEntity<Resource> downloadReceipt(@PathVariable Long bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        byte[] receiptBytes = receiptGeneratorService.generateReceiptPDF(booking);

        ByteArrayResource resource = new ByteArrayResource(receiptBytes);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=receipt.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(receiptBytes.length)
                .body(resource);
    }

    @GetMapping()
    public List<Booking> getAllBooking(){
        return bookingService.getAllBookings();
    }
    @PostMapping()
    public Booking createBooking(@RequestBody Booking booking){
        return bookingService.saveBooking(booking);
    }

    //@PutMapping
    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id){
        return bookingService.deleteBooking(id);
    }
}
