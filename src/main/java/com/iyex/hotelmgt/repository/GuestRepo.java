package com.iyex.hotelmgt.repository;

import com.iyex.hotelmgt.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GuestRepo extends JpaRepository<Guest,Long> {
    @Transactional
    @Modifying
    @Query("update Guest g set g.firstName = ?1 where g.firstName = ?2 and g.lastName = ?3")
    int updateFirstNameByFirstNameAndLastName(String firstName, String firstName1, String lastName);

}
