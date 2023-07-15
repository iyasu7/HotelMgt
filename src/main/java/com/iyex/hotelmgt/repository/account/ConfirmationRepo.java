package com.iyex.hotelmgt.repository.account;

import com.iyex.hotelmgt.domain.account.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationRepo extends JpaRepository<Confirmation, Long> {
    Confirmation findByConfirmationLink(String confirmationLink);
}