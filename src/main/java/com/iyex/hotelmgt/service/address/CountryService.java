package com.iyex.hotelmgt.service.address;

import com.iyex.hotelmgt.domain.address.Country;
import com.iyex.hotelmgt.repository.address.CountryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepo countryRepo;

    public Country getCountry(Long id){
        return countryRepo.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Country with id " + id + " not found!!"));
    }
    public Country getCountryByCountryName(String countryName){
        return countryRepo.findByCountryName(countryName);
    }
    public List<Country> getAllCountry(){
        return countryRepo.findAll();
    }
    public Country saveCountry(Country country){
        return countryRepo.save(country);
    }
    // updateCountry
    public String deleteCountry(Long id){
        countryRepo.deleteById(id);
        return "Country with id " + id + " was deleted!!";
    }

}
