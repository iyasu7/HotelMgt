package com.iyex.hotelmgt.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.iyex.hotelmgt.domain.account.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID bookingNumber;
//    user,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "booking")
    @ToString.Exclude
    @JsonManagedReference
    private Set<BookingService> bookingServices;

//    @OneToOne
//    @JoinColumn(name = "room_id")
//    @ToString.Exclude
//    @JsonBackReference
//    private Room room;

    @OneToMany
//    @JoinTable(name = "booking_roomUnavailability",
//            joinColumns = @JoinColumn(name = "booking_id"),
//            inverseJoinColumns = @JoinColumn(name = "roomUnavailability_id"))
    @ToString.Exclude
    @JsonManagedReference
    private Set<RoomUnavailability> roomUnavailability;

    @ManyToOne
    @JoinColumn(name = "hotel_id",nullable = false)
    private Hotel hotel;

    private LocalDateTime bookingDate = LocalDateTime.now();
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;

    private boolean paid;

    private boolean expired;

    public void updateExpirationStatus(int bookingExpirationTime){
        if (!this.paid && LocalDateTime.now().isAfter(this.bookingDate.plusHours(bookingExpirationTime))){
            this.expired = true;
        }
    }
    public boolean lessThanthreeHoursLeftEmailNotification(int bookingExpirationTime){
        return !this.paid && LocalDateTime.now().isAfter(this.bookingDate.plusHours(bookingExpirationTime).minusHours(3));
    }
    public BigDecimal getTotalAmount() {
        BigDecimal totalAmount = BigDecimal.ZERO;

        // Calculate room prices
        for (RoomUnavailability roomUnavailability1 : roomUnavailability) {
            BigDecimal roomPricePerNight = BigDecimal.valueOf(roomUnavailability1.getRoom().getPricePerNight());
            int numberOfNights = (int) ChronoUnit.DAYS.between(checkInDate.toLocalDate(), checkOutDate.toLocalDate());
            BigDecimal roomTotalPrice = roomPricePerNight.multiply(BigDecimal.valueOf(numberOfNights));
            totalAmount = totalAmount.add(roomTotalPrice);
        }

        // Calculate service prices
        for (BookingService bookingService : bookingServices) {
            BigDecimal servicePrice = BigDecimal.valueOf(bookingService.getService().getPrice());
            totalAmount = totalAmount.add(servicePrice);
        }

        return totalAmount;
    }

//    paymentDetails;
//     Update room availability when check-out is performed

    // DON'T THINK THIS METHODS R NECESSARY

//    public void performCheckOut(Room room) {
//        if (room != null) {
//            room.setUnavailabilities(true);
//        }
//    }
//
//    // Update room availability when check-in or check-out dates are modified
//    public void updateRoomAvailability(Room room) {
//        if (room != null) {
//            LocalDateTime currentDate = LocalDateTime.now();
//            boolean isWithinBookingPeriod = currentDate.isAfter(this.checkInDate) && currentDate.isBefore(this.checkOutDate);
//            room.setUnavailabilities();
////            room.set(!isWithinBookingPeriod);
//        }
//    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Booking booking = (Booking) o;
        return getId() != null && Objects.equals(getId(), booking.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
