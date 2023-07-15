package com.iyex.hotelmgt.repository;

import com.iyex.hotelmgt.domain.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepo extends JpaRepository<Service,Long> {
//    Service findByHotelId(Long id);

}
