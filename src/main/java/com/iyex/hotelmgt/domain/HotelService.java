package com.iyex.hotelmgt.domain;

import com.iyex.hotelmgt.utils.HotelServiceKey;
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
    private Hotel hotel;
    @ManyToOne
    @MapsId("serviceId")
    @JoinColumn(name = "service_id")
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
