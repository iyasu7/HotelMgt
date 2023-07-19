package com.iyex.hotelmgt.service;

import com.iyex.hotelmgt.domain.RoomType;
import com.iyex.hotelmgt.repository.RoomTypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RoomTypeService {
    private final RoomTypeRepo roomTypeRepo;

    public RoomType getRoomType(Long id){
        return roomTypeRepo.findById(id)
                .orElseThrow(()->new NoSuchElementException("RoomType with id " + id + " was not found"));
    }
    public List<RoomType> getAllRoomTypes(){
        return roomTypeRepo.findAll();
    }
    public RoomType saveRoomType(RoomType roomType, MultipartFile[] photos){
        handleFileUpload(roomType,photos);

        return roomTypeRepo.save(roomType);
    }

//    update RoomType

    public String deleteRoomType(Long id){
        roomTypeRepo.deleteById(id);
        return "RoomType with id " + id + " was Deleted!!!";
    }

    public void handleFileUpload(RoomType roomType, MultipartFile[] photos) {
        if (photos != null) {
            for (MultipartFile photo : photos) {
                try {
                    byte[] photoBytes = photo.getBytes();
                    roomType.addRoomPhoto(photoBytes);
                } catch (IOException e) {
                    // Handle the exception accordingly
                    throw new RuntimeException("Failed to handle file upload: " + e.getMessage(), e);
                }
            }
        }
    }
}
