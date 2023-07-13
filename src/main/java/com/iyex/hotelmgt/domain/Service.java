package com.iyex.hotelmgt.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;
    private String serviceDescription;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "service_type")
    @JsonBackReference
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service")
    @JsonManagedReference
    private Set<BookingService> bookingServices;

    @OneToMany(mappedBy = "service")
    @JsonManagedReference
    private Set<HotelService> hotelServices;

}