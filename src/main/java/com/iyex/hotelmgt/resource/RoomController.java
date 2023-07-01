package com.iyex.hotelmgt.resource;

import com.iyex.hotelmgt.domain.Room;
import com.iyex.hotelmgt.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable Long id){
        return roomService.getRoom(id);
    }
    @GetMapping()
    public List<Room> getAllRoom(){
        return roomService.getAllRooms();
    }
    @PostMapping()
    public Room createRoom(@RequestBody Room room){
        return roomService.saveRoom(room);
    }
    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable Long id){
        return roomService.deleteRoom(id);
    }
}
