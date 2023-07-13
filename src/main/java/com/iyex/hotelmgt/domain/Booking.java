package com.iyex.hotelmgt.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.iyex.hotelmgt.domain.account.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
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

    @OneToOne
    @JoinColumn(name = "room_id")
    @ToString.Exclude
    @JsonBackReference
    private Room room;

//    @ManyToOne
//    private Hotel hotel;

    private LocalDateTime bookingDate;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;

//    paymentDetails;
    // Update room availability when check-out is performed
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
//            room.setAvailable(!isWithinBookingPeriod);
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
