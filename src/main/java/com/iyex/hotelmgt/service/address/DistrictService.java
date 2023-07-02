package com.iyex.hotelmgt.service.address;

import com.iyex.hotelmgt.domain.address.District;
import com.iyex.hotelmgt.repository.address.DistrictRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DistrictService {

    public final DistrictRepo districtRepo;

    public District getDistrictById(Long id){
        return districtRepo.findById(id)
                .orElseThrow(()-> new NoSuchElementException("District with id " + id + " not found!!"));
    }
    public District getDistrictByDistrictName(String districtName){

        District district = districtRepo.findDistrictByDistrictName(districtName);

//        if (district == null) {
//            return ResponseEntity.notFound().build(); // Return 404 Not Found status
//        } else {
//            return ResponseEntity.ok(district); // Return 200 OK status with the district object
//        }
        if (district == null) {
            throw new RuntimeException("District with name " + districtName + " was not found!!");
        }
        return district;
    }
    public List<District> getAllDistrict(){
        return districtRepo.findAll();
    }
    public District saveDistrict(District district) {
        return districtRepo.save(district);
    }

    // updateDistrict
    public String deleteDistrict(Long id){
        districtRepo.deleteById(id);
        return "District with id " + id + " was deleted!!";
    }


}
