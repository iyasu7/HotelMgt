package com.iyex.hotelmgt.service;

import com.iyex.hotelmgt.domain.Hotel;
import com.iyex.hotelmgt.repository.HotelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepo hotelRepo;

    public Hotel getHotel(@PathVariable Long id){
        return hotelRepo.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Hotel with id " + id + " not found"));
    }
    public List<Hotel> getAllHotel(){
        return hotelRepo.findAll();
    }
    public Hotel saveHotel(Hotel hotel){
        return hotelRepo.save(hotel);
    }
    //update hotel

    public String deleteHotel(Long id){
        hotelRepo.deleteById(id);
        return "Hotel with id " + id + " was deleted";
    }

}
