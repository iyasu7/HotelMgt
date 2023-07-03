package com.iyex.hotelmgt.resource.address;

import com.iyex.hotelmgt.domain.address.Region;
import com.iyex.hotelmgt.domain.address.City;
import com.iyex.hotelmgt.service.address.RegionService;
import com.iyex.hotelmgt.service.address.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cities")
public class CityController {
    private final CityService cityService;
    private final RegionService regionService;

    @GetMapping("/{id}")
    public City getCityById(@PathVariable Long id){
       return cityService.getCityById(id);
    }
    @GetMapping()
    public List<City> getCountries(){
       return cityService.getAllCity();
    }

    @PostMapping()
    public City createCity(@RequestBody City city,@RequestParam String regionName){
        City city1 = cityService.saveCity(city);
        Region region = regionService.getRegionByRegionName(regionName);
        city1.setRegion(region);
        return city1;
    }
    //@PutMapping
    @DeleteMapping("/{id}")
    public String deleteCityById(@PathVariable Long id){
        return cityService.deleteCity(id);
    }

}
