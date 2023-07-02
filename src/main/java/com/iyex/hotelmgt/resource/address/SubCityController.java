package com.iyex.hotelmgt.resource.address;

import com.iyex.hotelmgt.domain.address.City;
import com.iyex.hotelmgt.domain.address.SubCity;
import com.iyex.hotelmgt.service.address.CityService;
import com.iyex.hotelmgt.service.address.SubCityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subcites")
public class SubCityController {
    private final SubCityService subCityService;
    private final CityService cityService;

    @GetMapping("/{id}")
    public SubCity getSubCityById(@PathVariable Long id){
       return subCityService.getSubCityById(id);
    }
    @GetMapping()
    public List<SubCity> getCountries(){
       return subCityService.getAllSubCity();
    }

    @PostMapping()
    public SubCity createSubCity(@RequestBody SubCity subCity,@RequestParam String cityName){
        SubCity subCity1 = subCityService.saveSubCity(subCity);
        City city = cityService.getCityByCityName(cityName);
        subCity1.setCity(city);
        return subCity1;
    }
    //@PutMapping
    @DeleteMapping("/{id}")
    public String deleteSubCityById(@PathVariable Long id){
        return subCityService.deleteSubCity(id);
    }

}
