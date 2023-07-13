package com.iyex.hotelmgt.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private int numberOfAvailableRooms;
    private int numberOfBeds;
    private Boolean doesContainPrivateBathroom;
    private Boolean hasTV;
    private Boolean hasBalcony;
    private Boolean hasRoomService;
    private String roomTypeName;
    private String description;

    @OneToMany(mappedBy = "roomType")
    @JsonManagedReference
    private List<Room> rooms;
}