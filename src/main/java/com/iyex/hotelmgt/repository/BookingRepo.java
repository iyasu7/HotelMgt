package com.iyex.hotelmgt.repository;

import com.iyex.hotelmgt.domain.Booking;
import com.iyex.hotelmgt.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {

    Booking findBookingByBookingNumber(UUID bookingNumber);

}
