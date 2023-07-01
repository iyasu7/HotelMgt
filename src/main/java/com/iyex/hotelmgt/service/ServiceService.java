package com.iyex.hotelmgt.service;

import com.iyex.hotelmgt.repository.ServiceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ServiceService {
    private final ServiceRepo serviceRepo;

    public com.iyex.hotelmgt.domain.Service getService(Long id){
        return serviceRepo.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Service with id " + id + " not found"));
    }
    public List<com.iyex.hotelmgt.domain.Service> getAllServices(){
        return serviceRepo.findAll();
    }

    public com.iyex.hotelmgt.domain.Service saveService(com.iyex.hotelmgt.domain.Service service){
        return serviceRepo.save(service);
    }
    //update Service

    public String deleteService(Long id){
         serviceRepo.deleteById(id);
        return "Service with id " + id + " was Deleted!!";
    }

}
