package com.iyex.hotelmgt.utils;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
@Embeddable
@Data
public class HotelServiceKey implements Serializable {

    private Long hotelId;
    private Long serviceId;
}
