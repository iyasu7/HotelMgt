package com.iyex.hotelmgt.domain;

import com.iyex.hotelmgt.domain.address.Address;
import com.iyex.hotelmgt.enums.Star;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hotelName;

    private String description;
    private Star star;
    private int bookingExpirationTimeInHours;

    @ManyToOne
    @JoinColumn(name = "hotel_type")
    private HotelType type;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;

    @OneToMany(mappedBy = "hotel")
    private Set<Employee> employees;

    @OneToMany(mappedBy = "hotel")
    private Set<HotelService> hotelServices;

    @OneToMany(mappedBy = "hotel")
    private Set<HotelRating> ratings;

}
