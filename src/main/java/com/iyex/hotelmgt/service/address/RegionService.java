package com.iyex.hotelmgt.service.address;

import com.iyex.hotelmgt.domain.address.Region;
import com.iyex.hotelmgt.repository.address.RegionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RegionService {

    public final RegionRepo regionRepo;

    public Region getRegionById(Long id){
        return regionRepo.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Region with id " + id + " not found!!"));
    }
    public Region getRegionByRegionName(String regionName){

        Region region = regionRepo.findByRegionName(regionName);

//        if (region == null) {
//            return ResponseEntity.notFound().build(); // Return 404 Not Found status
//        } else {
//            return ResponseEntity.ok(region); // Return 200 OK status with the region object
//        }
        if (region == null) {
            throw new RuntimeException("Region with name " + regionName + " was not found!!");
        }
        return region;
    }
    public List<Region> getAllRegion(){
        return regionRepo.findAll();
    }
    public Region saveRegion(Region region) {
        return regionRepo.save(region);
    }

    // updateRegion
    public String deleteRegion(Long id){
        regionRepo.deleteById(id);
        return "Region with id " + id + " was deleted!!";
    }


}
