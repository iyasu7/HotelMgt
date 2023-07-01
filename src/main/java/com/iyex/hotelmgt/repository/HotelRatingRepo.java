package com.iyex.hotelmgt.repository;

import com.iyex.hotelmgt.domain.HotelRating;
import com.iyex.hotelmgt.domain.key.HotelRatingKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRatingRepo extends JpaRepository<HotelRating, HotelRatingKey> {
}