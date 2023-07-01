package com.iyex.hotelmgt.service.address;

import com.iyex.hotelmgt.domain.address.Region;
import com.iyex.hotelmgt.repository.address.CountryRepo;
import com.iyex.hotelmgt.repository.address.RegionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RegionService {

    public final RegionRepo regionRepo;
    public final CountryRepo countryRepo;

    public Region getRegion(Long id){
        return regionRepo.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Region with id " + id + " not found!!"));
    }
    public List<Region> getAllRegion(){
        return (List<Region>) regionRepo.findAll();
    }
    public Region saveRegion(Region region){
        return regionRepo.save(region);
    }
    // updateRegion
    public String deleteRegion(Long id){
        regionRepo.deleteById(id);
        return "Region with id " + id + " was deleted!!";
    }


}
