package com.iyex.hotelmgt.service;

import com.iyex.hotelmgt.domain.Rating;
import com.iyex.hotelmgt.repository.RatingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepo ratingRepo;

    public Rating getRatingById(Long id){
        return ratingRepo.findById(id).orElseThrow(()->new NoSuchElementException("Rating with id " + id + " not found"));
    }
    public double getAverageRatingByHotelId(Long hotelId){
        return ratingRepo.findAverageRatingByHotelId(hotelId);
    }
    public Rating saveRating(Rating rating){
        return ratingRepo.save(rating);
    }
    //Update
    public Rating updateRating(Long id,Rating updateRating){
        Rating rating = getRatingById(id);
        rating.setRating(updateRating.getRating());
        return ratingRepo.save(rating);
    }
    public String deleteById(Long id){
        ratingRepo.deleteById(id);
        return "Rating with id " + id + " was Deleted!!";
    }
}
