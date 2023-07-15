package com.iyex.hotelmgt.service;

import com.iyex.hotelmgt.domain.Booking;
import com.iyex.hotelmgt.domain.Room;
import com.iyex.hotelmgt.domain.RoomUnavailability;
import com.iyex.hotelmgt.repository.BookingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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
        Set<Room> rooms = booking.getRoomUnavailability()
                .stream()
                .map(RoomUnavailability::getRoom)
                .collect(Collectors.toSet());

        roomUnavailabilityService.makeRoomsUnavailable(rooms,booking.getCheckInDate(),booking.getCheckOutDate());
        booking.setBookingNumber(UUID.randomUUID());
        booking.setBookingDate(LocalDateTime.now());
        return bookingRepo.save(booking);
    }
    //update booking

    public String deleteBooking(Long id){
        Booking booking = getBooking(id);
        Set<Room> rooms = booking.getRoomUnavailability()
                .stream()
                .map(RoomUnavailability::getRoom)
                .collect(Collectors.toSet());
        Set<RoomUnavailability> roomUnavailabilitySet = new HashSet<>();
        for (Room room :
                rooms) {
         roomUnavailabilitySet.add(roomUnavailabilityService.getRoomUnavailabilityByRoomStartAndEndDate(
                 room,booking.getCheckInDate(),booking.getCheckOutDate()));
        }
         roomUnavailabilityService.deleteAllRoomUnavailability(roomUnavailabilitySet);
         bookingRepo.delete(booking);
        return "Booking with id " + id + " was Deleted!!";
    }



}
