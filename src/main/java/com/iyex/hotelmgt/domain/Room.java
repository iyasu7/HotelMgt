package com.iyex.hotelmgt.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;
    private int floorNumber;
    private double roomSize;
    private double price;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    @OneToOne(mappedBy = "room")
    private Booking booking;

    @OneToMany(mappedBy = "room")
    @ToString.Exclude
    private List<RoomUnavailability> unavailabilities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    @ToString.Exclude
    private Hotel hotel;

}
