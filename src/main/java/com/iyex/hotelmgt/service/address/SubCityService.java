package com.iyex.hotelmgt.service.address;

import com.iyex.hotelmgt.domain.address.SubCity;
import com.iyex.hotelmgt.repository.address.SubCityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SubCityService {

    public final SubCityRepo subCityRepo;

    public SubCity getSubCityById(Long id){
        return subCityRepo.findById(id)
                .orElseThrow(()-> new NoSuchElementException("SubCity with id " + id + " not found!!"));
    }
    public SubCity getSubCityBySubCityName(String subCityName){

        SubCity subCity = subCityRepo.findSubCityBySubCityName(subCityName);

//        if (subCity == null) {
//            return ResponseEntity.notFound().build(); // Return 404 Not Found status
//        } else {
//            return ResponseEntity.ok(subCity); // Return 200 OK status with the subCity object
//        }
        if (subCity == null) {
            throw new RuntimeException("SubCity with name " + subCityName + " was not found!!");
        }
        return subCity;
    }
    public List<SubCity> getAllSubCity(){
        return subCityRepo.findAll();
    }
    public SubCity saveSubCity(SubCity subCity) {
        return subCityRepo.save(subCity);
    }

    // updateSubCity
    public String deleteSubCity(Long id){
        subCityRepo.deleteById(id);
        return "SubCity with id " + id + " was deleted!!";
    }


}
