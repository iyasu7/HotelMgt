package com.iyex.hotelmgt.resource.address;

import com.iyex.hotelmgt.domain.address.Country;
import com.iyex.hotelmgt.service.address.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable Long id){
       return countryService.getCountry(id);
    }
    @GetMapping()
    public Page<Country> getCountries(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "20") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy){
       return countryService.getAllCountry(pageNumber,pageSize,sortBy);
    }

    @PostMapping()
    public Country createCountry(@RequestBody Country country){
        return countryService.saveCountry(country);
    }
    //@PutMapping
    @DeleteMapping("/{id}")
    public String deleteCountryById(@PathVariable Long id){
        return countryService.deleteCountry(id);
    }

}
