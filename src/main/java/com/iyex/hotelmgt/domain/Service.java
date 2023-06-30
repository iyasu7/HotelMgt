package com.iyex.hotelmgt.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;
    private String serviceDescription;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "service_type")
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service")
    private Set<BookingService> bookingServices;

    @OneToMany(mappedBy = "service")
    private Set<HotelService> hotelServices;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Service service = (Service) o;
        return getId() != null && Objects.equals(getId(), service.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}