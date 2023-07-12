package com.iyex.hotelmgt.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class HotelType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hotelTypeName;

    private String description;

    @OneToMany(mappedBy = "type")
    private Set<Hotel> hotels;

}
