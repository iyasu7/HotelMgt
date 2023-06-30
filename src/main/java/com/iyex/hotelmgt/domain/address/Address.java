package com.iyex.hotelmgt.domain.address;

import com.iyex.hotelmgt.domain.Hotel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    @ManyToOne
    @JoinColumn(name = "subCity_id")
    private SubCity subCity;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    private String description;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Hotel> hotel;
}
