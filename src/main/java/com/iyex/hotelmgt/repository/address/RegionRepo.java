package com.iyex.hotelmgt.repository.address;

import com.iyex.hotelmgt.domain.address.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepo extends JpaRepository<Region, Long> {
    Region findByRegionName(String regionName);
}