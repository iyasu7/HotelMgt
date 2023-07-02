package com.iyex.hotelmgt.service.address;

import com.iyex.hotelmgt.domain.address.City;
import com.iyex.hotelmgt.repository.address.CityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CityService {

    public final CityRepo cityRepo;

    public City getCityById(Long id){
        return cityRepo.findById(id)
                .orElseThrow(()-> new NoSuchElementException("City with id " + id + " not found!!"));
    }
    public City getCityByCityName(String cityName){

        City city = cityRepo.findCityByCityName(cityName);

//        if (city == null) {
//            return ResponseEntity.notFound().build(); // Return 404 Not Found status
//        } else {
//            return ResponseEntity.ok(city); // Return 200 OK status with the city object
//        }
        if (city == null) {
            throw new RuntimeException("City with name " + cityName + " was not found!!");
        }
        return city;
    }
    public List<City> getAllCity(){
        return (List<City>) cityRepo.findAll();
    }
    public City saveCity(City city) {
        return cityRepo.save(city);
    }

    // updateCity
    public String deleteCity(Long id){
        cityRepo.deleteById(id);
        return "City with id " + id + " was deleted!!";
    }


}
