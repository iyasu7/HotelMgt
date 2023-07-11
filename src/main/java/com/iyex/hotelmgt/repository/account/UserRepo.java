package com.iyex.hotelmgt.repository.account;

import com.iyex.hotelmgt.domain.Hotel;
import com.iyex.hotelmgt.domain.account.User;
import com.iyex.hotelmgt.domain.account.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepo extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
    Set<User> findUserByUserType(UserType userType);
    Set<User> findUserByHotel(Hotel hotel);
}