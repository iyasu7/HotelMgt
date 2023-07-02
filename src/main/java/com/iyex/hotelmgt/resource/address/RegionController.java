package com.iyex.hotelmgt.resource.address;

import com.iyex.hotelmgt.domain.address.Region;
import com.iyex.hotelmgt.service.address.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
public class RegionController {
    private final RegionService regionService;

    @GetMapping("/{id}")
    public Region getRegionById(@PathVariable Long id){
       return regionService.getRegionById(id);
    }
    @GetMapping()
    public List<Region> getCountries(){
       return regionService.getAllRegion();
    }

    @PostMapping()
    public Region createRegion(@RequestBody Region region){
        return regionService.saveRegion(region);
    }
    //@PutMapping
    @DeleteMapping("/{id}")
    public String deleteRegionById(@PathVariable Long id){
        return regionService.deleteRegion(id);
    }

}
