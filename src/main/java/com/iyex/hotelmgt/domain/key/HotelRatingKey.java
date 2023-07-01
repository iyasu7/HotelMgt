package com.iyex.hotelmgt.domain.key;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class HotelRatingKey implements Serializable {

    private Long guestId;
    private Long hotelId;

}
