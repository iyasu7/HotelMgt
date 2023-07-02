package com.iyex.hotelmgt.resource;

import com.iyex.hotelmgt.domain.Hotel;
import com.iyex.hotelmgt.domain.Rating;
import com.iyex.hotelmgt.service.HotelService;
import com.iyex.hotelmgt.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ratings")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;
    private final HotelService hotelService;

    @GetMapping("/{hotelId}")
    public double getAverageRatingByHotelId(@PathVariable Long hotelId){
        return ratingService.getAverageRatingByHotelId(hotelId);
    }
    @PostMapping("{hotelId}")
    public Rating makeRating(@PathVariable Long hotelId, @RequestBody Rating rating){
        Rating savedRating = ratingService.saveRating(rating);
        Hotel hotel = hotelService.getHotel(hotelId);
        savedRating.setHotel(hotel);
        return savedRating;
    }

}
