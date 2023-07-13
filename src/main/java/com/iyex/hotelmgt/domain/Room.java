package com.iyex.hotelmgt.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    private RoomType roomType;

    @OneToOne(mappedBy = "room")
    @JsonBackReference
    private Booking booking;

    @OneToMany(mappedBy = "room")
    @ToString.Exclude
    @JsonManagedReference
    private List<RoomUnavailability> unavailabilities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    @ToString.Exclude
    @JsonBackReference
    private Hotel hotel;

}
