package com.iyex.hotelmgt.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.iyex.hotelmgt.domain.key.HotelServiceKey;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class HotelService {
    @EmbeddedId
    private HotelServiceKey id;

    @ManyToOne
    @MapsId("hotelId")
    @JoinColumn(name = "hotel_id")
    @JsonBackReference
    private Hotel hotel;

    @ManyToOne
    @MapsId("serviceId")
    @JoinColumn(name = "service_id")
    @JsonBackReference
    private Service service;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        HotelService that = (HotelService) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
