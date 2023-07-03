package com.iyex.hotelmgt.service;

import com.iyex.hotelmgt.domain.Booking;
import com.iyex.hotelmgt.repository.BookingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepo bookingRepo;

    public Booking getBooking(Long id){
        return bookingRepo.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Booking with id " + id + " not found"));
    }

    public Booking getBookingByBookingNumber(UUID bookingNumber) {
        return bookingRepo.findBookingByBookingNumber(bookingNumber);
    }

    public List<Booking> getAllBookings(){
        return bookingRepo.findAll();
    }

    public Booking saveBooking(Booking booking){
        return bookingRepo.save(booking);
    }
    //update booking

    public String deleteBooking(Long id){
         bookingRepo.deleteById(id);
        return "Booking with id " + id + " was Deleted!!";
    }

}
