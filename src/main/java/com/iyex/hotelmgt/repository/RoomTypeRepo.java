package com.iyex.hotelmgt.repository;

import com.iyex.hotelmgt.domain.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepo extends JpaRepository<RoomType, Long> {
    RoomType findByHotelId(Long hotel_id);
    RoomType findByRoomTypeName(String roomTypeName);
    RoomType findByNumberOfRooms(int numberOfRooms);
    RoomType findByNumberOfBeds(int numberOfBeds);
}