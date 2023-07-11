package com.iyex.hotelmgt.repository;

import com.iyex.hotelmgt.domain.Room;
import com.iyex.hotelmgt.domain.RoomUnavailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface RoomUnavailabilityRepo extends JpaRepository<RoomUnavailability, Long> {
    RoomUnavailability findRoomUnavailabilityByAvailable(boolean available);
    RoomUnavailability findRoomUnavailabilityByRoomAndStartTimeAndEndTime(Room room, LocalDateTime startTime, LocalDateTime endTime);
    RoomUnavailability findRoomUnavailabilityByStartTime(LocalDateTime startTime);
    RoomUnavailability findRoomUnavailabilityByEndTime(LocalDateTime endTime);
}