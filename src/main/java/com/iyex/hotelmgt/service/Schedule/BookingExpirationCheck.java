package com.iyex.hotelmgt.service.Schedule;

import com.iyex.hotelmgt.domain.Booking;
import com.iyex.hotelmgt.repository.BookingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookingExpirationCheck {

    private final BookingRepo bookingRepo;
    @Scheduled(fixedDelay = 3600000)
    public void checkBookingExpiration(){
        Set<Booking> notExpiredBookings = bookingRepo.findByExpired(false);
        for (Booking booking :
                notExpiredBookings) {
            booking.updateExpirationStatus(booking.getHotel().getBookingExpirationTimeInHours());
            bookingRepo.save(booking);
        }
    }
}
