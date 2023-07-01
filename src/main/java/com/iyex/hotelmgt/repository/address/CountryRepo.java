package com.iyex.hotelmgt.repository.address;

import com.iyex.hotelmgt.domain.address.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country, Long> {
    Country findByCountryName(String countryName);
}