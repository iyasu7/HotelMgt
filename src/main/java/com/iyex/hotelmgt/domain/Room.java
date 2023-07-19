package com.iyex.hotelmgt.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.iyex.hotelmgt.enums.RoomSize;
import com.iyex.hotelmgt.enums.View;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;
    private int floorNumber;
    private double pricePerNight;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    @JsonBackReference
    private RoomType roomType;

    @Enumerated(EnumType.STRING)
    private View view;

    @Enumerated(EnumType.STRING)
    private RoomSize roomSize;


//    @ManyToOne()
//    @JsonBackReference
//    private Booking booking;

    @OneToMany(mappedBy = "room")
    @ToString.Exclude
    @JsonManagedReference
    private List<RoomUnavailability> unavailabilities;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "hotel_id")
//    @ToString.Exclude
//    @JsonBackReference
//    private Hotel hotel;

    @ManyToMany
    @JoinTable(
            name = "room_amenities",
            joinColumns = {@JoinColumn(name = "room_id")},
            inverseJoinColumns = {@JoinColumn(name = "amenity_id")}
    )
    @ToString.Exclude
    private Set<Amenities> amenities;

}
