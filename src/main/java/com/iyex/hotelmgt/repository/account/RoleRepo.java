package com.iyex.hotelmgt.repository.account;

import com.iyex.hotelmgt.domain.account.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}