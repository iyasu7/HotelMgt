package com.iyex.hotelmgt.domain.account;


import com.iyex.hotelmgt.domain.Booking;
import com.iyex.hotelmgt.domain.Rating;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String username;

    @OneToMany(mappedBy = "guest")
    @ToString.Exclude
    private Set<Booking> bookings;

    @OneToMany(mappedBy = "guest")
    @ToString.Exclude
    private Set<Rating> ratings;


}
