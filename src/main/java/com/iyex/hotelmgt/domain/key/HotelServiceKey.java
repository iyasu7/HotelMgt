package com.iyex.hotelmgt.domain.key;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
@Embeddable
@Data
public class HotelServiceKey implements Serializable {

    private Long hotelId;
    private Long serviceId;
}
