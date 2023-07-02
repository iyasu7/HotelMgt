package com.iyex.hotelmgt.repository;

import com.iyex.hotelmgt.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Long> {
    double findAverageRatingByHotelId(Long hotelId);
}