package com.iyex.hotelmgt.domain;

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
    @JoinColumn(name = "guest_id")
    @ToString.Exclude
    private Guest guest;

    @OneToMany(mappedBy = "booking")
    @ToString.Exclude
    private Set<BookingService> bookingServices;

    @OneToOne
    @JoinColumn(name = "room_id")
    @ToString.Exclude
    private Room room;

//    @ManyToOne
//    private Hotel hotel;

    private LocalDateTime bookingDates;
//    paymentDetails;

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
