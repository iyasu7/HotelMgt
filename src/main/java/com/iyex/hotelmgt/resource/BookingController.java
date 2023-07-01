package com.iyex.hotelmgt.resource;

import com.iyex.hotelmgt.domain.Booking;
import com.iyex.hotelmgt.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable Long id){
        return bookingService.getBooking(id);
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
