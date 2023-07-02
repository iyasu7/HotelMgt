package com.iyex.hotelmgt.resource.address;

import com.iyex.hotelmgt.domain.address.District;
import com.iyex.hotelmgt.service.address.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/districts")
public class DistrictController {
    private final DistrictService districtService;

    @GetMapping("/{id}")
    public District getDistrictById(@PathVariable Long id){
       return districtService.getDistrictById(id);
    }
    @GetMapping()
    public List<District> getCountries(){
       return districtService.getAllDistrict();
    }

    @PostMapping()
    public District createDistrict(@RequestBody District district){
        return districtService.saveDistrict(district);
    }
    //@PutMapping
    @DeleteMapping("/{id}")
    public String deleteDistrictById(@PathVariable Long id){
        return districtService.deleteDistrict(id);
    }

}
