package com.iyex.hotelmgt.resource;

import com.iyex.hotelmgt.domain.Service;
import com.iyex.hotelmgt.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/services")
public class ServiceController {

    private final ServiceService serviceService;

    @GetMapping("/{id}")
    public Service getService(@PathVariable Long id){
        return serviceService.getService(id);
    }
    @GetMapping()
    public List<Service> getAllService(){
        return serviceService.getAllServices();
    }
    @PostMapping()
    public Service createService(@RequestBody Service service){
        return serviceService.saveService(service);
    }
    @DeleteMapping("/{id}")
    public String deleteService(@PathVariable Long id){
        return serviceService.deleteService(id);
    }

}
