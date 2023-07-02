package com.iyex.hotelmgt.resource;

import com.iyex.hotelmgt.domain.Hotel;
import com.iyex.hotelmgt.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    @GetMapping("/{id}")
    public Hotel getHotel(@PathVariable Long id ){
        return hotelService.getHotel(id);
    }
    @GetMapping
    public List<Hotel> getAllHotels(){
        return hotelService.getAllHotel();
    }
    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel){
        return hotelService.saveHotel(hotel);
    }
//    Update Hotel
//    @PutMapping

    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable Long id){
        return hotelService.deleteHotel(id);
    }
}
