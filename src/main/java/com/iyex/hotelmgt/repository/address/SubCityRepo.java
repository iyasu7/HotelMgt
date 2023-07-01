package com.iyex.hotelmgt.repository.address;

import com.iyex.hotelmgt.domain.address.SubCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCityRepo extends JpaRepository<SubCity, Long> {
}