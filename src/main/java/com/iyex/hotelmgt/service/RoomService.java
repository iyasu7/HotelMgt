package com.iyex.hotelmgt.service;

import com.iyex.hotelmgt.domain.Room;
import com.iyex.hotelmgt.repository.RoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepo roomRepo;

    public Room getRoom(Long id){
        Room room = roomRepo.findById(id).orElseThrow(()->new NoSuchElementException("Room with id " + id + " was not found"));
//        String roomsize = room.getRoomSize().name();
        return room;
    }
    public List<Room> getAllRooms(){
        return roomRepo.findAll();
    }
    public Room saveRoom(Room room){
        return roomRepo.save(room);
    }

//    update Room

    public String deleteRoom(Long id){
        roomRepo.deleteById(id);
        return "Room with id " + id + " was Deleted!!!";
    }
}
