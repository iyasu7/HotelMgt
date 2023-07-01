package com.iyex.hotelmgt.repository;

import com.iyex.hotelmgt.domain.HotelType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelTypeRepo extends JpaRepository<HotelType, Long> {
}