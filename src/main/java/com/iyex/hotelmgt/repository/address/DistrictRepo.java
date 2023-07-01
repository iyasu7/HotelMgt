package com.iyex.hotelmgt.repository.address;

import com.iyex.hotelmgt.domain.address.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepo extends JpaRepository<District, Long> {
}