package com.iyex.hotelmgt.repository;

import com.iyex.hotelmgt.domain.Amenities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenitiesRepo extends JpaRepository<Amenities, Long> {
    Amenities findByAmenityName(String amenityName);
}