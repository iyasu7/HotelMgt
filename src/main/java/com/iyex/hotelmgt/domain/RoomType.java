package com.iyex.hotelmgt.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomTypeName;
    private int numberOfRooms;
    private int numberOfAvailableRooms;
    private int numberOfBeds;
//    private double roomSize;
    private String description;

    @ElementCollection
    private List<byte[]> photos;


    @OneToMany(mappedBy = "roomType")
    @JsonManagedReference
    private List<Room> rooms;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    @ToString.Exclude
    @JsonBackReference
    private Hotel hotel;

    public void addRoomPhoto(byte[] photo) {
        if (photos.size() < 8) {
            photos.add(photo);
        } else {
            throw new IllegalArgumentException("Maximum number of room photos reached (8)");
        }
    }
    public void removeRoomPhoto(byte[] photo) {
            photos.remove(photo);
    }
}