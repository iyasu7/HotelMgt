package com.iyex.hotelmgt.service.address;

import com.iyex.hotelmgt.domain.address.Country;
import com.iyex.hotelmgt.repository.address.CountryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

        Country country = countryRepo.findByCountryName(countryName);

//        if (country == null) {
//            return ResponseEntity.notFound().build(); // Return 404 Not Found status
//        } else {
//            return ResponseEntity.ok(country); // Return 200 OK status with the country object
//        }
        if (country == null) {
            throw new RuntimeException("Country with name " + countryName + " was not found!!");
        }
        return country;
    }
    public Page<Country> getAllCountry(int pageNumber, int pageSize, String sort){
        Pageable pageable = PageRequest.of(pageNumber,pageSize,Sort.by(sort));
        return countryRepo.findAll(pageable);
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
