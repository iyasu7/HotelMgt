package com.iyex.hotelmgt.repository.account;

import com.iyex.hotelmgt.domain.account.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepo extends JpaRepository<Guest,Long> {
    Guest findGuestByUsername(String username);
}
