package com.iyex.hotelmgt.service;

import com.iyex.hotelmgt.domain.Booking;
import com.iyex.hotelmgt.domain.RoomUnavailability;
import com.iyex.hotelmgt.repository.BookingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepo bookingRepo;
    private final RoomUnavailabilityService roomUnavailabilityService;

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
        roomUnavailabilityService.makeRoomUnavailable(booking.getRoom(),booking.getCheckInDate(),booking.getCheckOutDate());
        booking.setBookingNumber(UUID.randomUUID());
        booking.setBookingDate(LocalDateTime.now());
        return bookingRepo.save(booking);
    }
    //update booking

    public String deleteBooking(Long id){
        Booking booking = getBooking(id);
         RoomUnavailability roomUnavailability = roomUnavailabilityService.getRoomUnavailabilityByRoomStartAndEndDate(
                 booking.getRoom(),booking.getCheckInDate(),booking.getCheckOutDate());
         roomUnavailabilityService.deleteRoomUnavailability(roomUnavailability.getId());
         bookingRepo.delete(booking);
        return "Booking with id " + id + " was Deleted!!";
    }

}
