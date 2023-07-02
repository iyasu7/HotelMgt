package com.iyex.hotelmgt.service.address;

import com.iyex.hotelmgt.domain.address.Address;
import com.iyex.hotelmgt.repository.address.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepo addressRepo;

    public Address getAddressById(Long id){
        return addressRepo.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Address with id " + id + " not found!!"));
    }
    public List<Address> getAllAddress(){
        return addressRepo.findAll();
    }
    public Address saveAddress(Address address) {
        return addressRepo.save(address);
    }

    // updateAddress
    public String deleteAddress(Long id){
        addressRepo.deleteById(id);
        return "Address with id " + id + " was deleted!!";
    }

}
