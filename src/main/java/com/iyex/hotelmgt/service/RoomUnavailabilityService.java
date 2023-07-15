package com.iyex.hotelmgt.service;

import com.iyex.hotelmgt.domain.Room;
import com.iyex.hotelmgt.domain.RoomUnavailability;
import com.iyex.hotelmgt.repository.RoomUnavailabilityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoomUnavailabilityService {

    private final RoomUnavailabilityRepo roomUnavailabilityRepo;

    public RoomUnavailability getRoomUnavailabilityByRoomStartAndEndDate(Room room, LocalDateTime startTime, LocalDateTime endTime){
        RoomUnavailability roomUnavailability = roomUnavailabilityRepo.
                findRoomUnavailabilityByRoomAndStartTimeAndEndTime(room,startTime,endTime);
        if (roomUnavailability == null) {
            throw new NoSuchElementException("Nothing booked with this dates for this room");
        }
        return roomUnavailability;
    }

    public List<RoomUnavailability> makeRoomsUnavailable(Set<Room> rooms, LocalDateTime startTime, LocalDateTime endTime){
        List<RoomUnavailability> roomUnavailabilityList = new ArrayList<>();
        for (Room room : rooms) {
            RoomUnavailability roomUnavailability = RoomUnavailability.builder()
                    .room(room)
                    .startTime(startTime)
                    .endTime(endTime)
                    .unavailable(true)
                    .build();


        }
            roomUnavailabilityRepo.saveAll(roomUnavailabilityList);
        return roomUnavailabilityList;
    }
    public RoomUnavailability updateDates(Long roomUnavailabilityId, RoomUnavailability updateRoomUnavailability){
        RoomUnavailability roomUnavailability =  roomUnavailabilityRepo.findById(roomUnavailabilityId).orElseThrow(()-> new NoSuchElementException("Nothing booked with this date in this room before"));
        roomUnavailability.setStartTime(updateRoomUnavailability.getStartTime());
        roomUnavailability.setEndTime(updateRoomUnavailability.getEndTime());
        return roomUnavailability;
    }
    public boolean isRoomAvailable(Room room, LocalDateTime startTime, LocalDateTime endTime) {
        List<RoomUnavailability> unavailabilities = room.getUnavailabilities();

        LocalDateTime now = LocalDateTime.now();

        for (RoomUnavailability unavailability : unavailabilities) {
            LocalDateTime unavailabilityStartTime = unavailability.getStartTime();
            LocalDateTime unavailabilityEndTime = unavailability.getEndTime();

            // Skip unavailability before the current date
            if (unavailabilityEndTime.isBefore(now)) {
                continue;
            }

            if (startTime.isAfter(unavailabilityStartTime) || endTime.isBefore(unavailabilityEndTime) || unavailability.isUnavailable()) {
                return false;
            }
        }

        return true;
    }

    public String deleteRoomUnavailability(Long roomUnavailabilityId) {
        roomUnavailabilityRepo.deleteById(roomUnavailabilityId);
        return "Room unavailability has been deleted";
    }
    public void deleteAllRoomUnavailability(Set<RoomUnavailability> roomUnavailabilitySet) {
        roomUnavailabilityRepo.deleteAll(roomUnavailabilitySet);
    }
}
