package com.iyex.hotelmgt.repository;

import com.iyex.hotelmgt.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Room,Long> {
//    List<Room> findByHotelId(Long hotel_id);

}
