package com.iyex.hotelmgt.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.iyex.hotelmgt.domain.account.User;
import com.iyex.hotelmgt.domain.address.District;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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
    private String phoneNumber;
    private String hotelEmail;

    private int star;
    private int reservationTimeForBookingToExpire;

    @ManyToOne
    @JoinColumn(name = "hotel_type")
    @JsonBackReference
    private HotelType type;

    @ManyToOne
    @JoinColumn(name = "district_id")
    @JsonBackReference
    private District district;

    @OneToMany(mappedBy = "hotel")
    @JsonManagedReference
    private List<RoomType> roomTypes;

    @OneToMany(mappedBy = "hotel")
    @JsonManagedReference
    private Set<User> employees;

    //ManyToMany b/n Hotel and Services
    @OneToMany(mappedBy = "hotel")
    @JsonManagedReference
    private Set<HotelService> hotelServices;

    @OneToMany(mappedBy = "hotel")
    private Set<Booking> bookings;

    @OneToMany(mappedBy = "hotel")
    @JsonManagedReference
    private Set<Rating> ratings;

    @OneToMany(mappedBy = "hotel")
    @JsonManagedReference
    private Set<Review> reviews;

}
