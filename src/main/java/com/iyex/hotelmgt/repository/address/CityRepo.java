package com.iyex.hotelmgt.repository.address;

import com.iyex.hotelmgt.domain.address.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {
}