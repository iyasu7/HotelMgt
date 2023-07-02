package com.iyex.hotelmgt.resource.address;

import com.iyex.hotelmgt.domain.address.Address;
import com.iyex.hotelmgt.service.address.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;
    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Long id){
        return  addressService.getAddressById(id);
    }
    @GetMapping()
    public List<Address> getAddresses(){
        return  addressService.getAllAddress();
    }
    @PostMapping()
    public Address createAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }
    //@PutMapping

    @DeleteMapping("/{id}")
    public String getDeleteById(@PathVariable Long id){
        return addressService.deleteAddress(id);
    }


}
