package com.iyex.hotelmgt.resource;

import com.iyex.hotelmgt.domain.RoomType;
import com.iyex.hotelmgt.service.RoomTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roomtype")
public class RoomTypeController {
    private final RoomTypeService roomTypeService;

    @GetMapping("/{id}")
    public RoomType getRoomType(@PathVariable Long id){
        return roomTypeService.getRoomType(id);
    }
    @GetMapping()
    public List<RoomType> getAllRoomType(){
        return roomTypeService.getAllRoomTypes();
    }
    @PostMapping()
    public RoomType createRoomType(@RequestBody RoomType room,
                                   @RequestParam("photos") MultipartFile[] photos){
        return roomTypeService.saveRoomType(room,photos);
    }
    @DeleteMapping("/{id}")
    public String deleteRoomType(@PathVariable Long id){
        return roomTypeService.deleteRoomType(id);
    }
}
