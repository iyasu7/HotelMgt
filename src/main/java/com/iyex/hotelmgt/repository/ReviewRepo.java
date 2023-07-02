package com.iyex.hotelmgt.repository;

import com.iyex.hotelmgt.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {
    List<Review> findReviewByHotelId(Long hotelId);
}