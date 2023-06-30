package com.iyex.hotelmgt.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberOfRooms;
    private int numberOfBeds;
    private Boolean doesContainPrivateBathroom;
    private Boolean hasTV;
    private Boolean hasBalcony;
    private Boolean hasRoomService;

    @OneToMany(mappedBy = "roomType")
    private List<Room> rooms;
}