package com.iyex.hotelmgt.service.Schedule;

import com.iyex.hotelmgt.domain.Booking;
import com.iyex.hotelmgt.repository.BookingRepo;
import com.iyex.hotelmgt.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookingExpirationCheck {

    private final BookingRepo bookingRepo;
    private final EmailService emailService;
    //runs every 1 hour
    @Scheduled(fixedDelay = 3600000)
    public void checkBookingExpiration(){
        Set<Booking> notExpiredBookings = bookingRepo.findByExpired(false);
        for (Booking booking :
                notExpiredBookings) {
            booking.updateExpirationStatus(booking.getHotel().getReservationTimeForBookingToExpire());
            if (booking.lessThanthreeHoursLeftEmailNotification(booking.getHotel().getReservationTimeForBookingToExpire())){
                emailService.sendLessThanThreeHoursLeftNotification(booking);
            }
            bookingRepo.save(booking);
        }
    }
}
