package com.iyex.hotelmgt.service;

import com.iyex.hotelmgt.domain.Guest;
import com.iyex.hotelmgt.repository.GuestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GuestService {


    private final GuestRepo guestRepo;

    public Page<Guest> getGuests(int pageNumber, int pageSize , String sortBy) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return guestRepo.findAll(pageable);
    }

    public Guest getGuestById(Long id){
        return guestRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Guest with id " + id + " not found"));
    }

    public Guest saveGuest(Guest guest) {
        return guestRepo.save(guest);
    }

//    public Guest updateGuest(Guest updateGuest,Long id){
//        Guest guest = guestRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Guest with id " + id +"  not found"));
//        return guestRepo.save(guest);
//    }
// Update
//    public Guest updateGuest(Long id, Guest updatedGuest) {
//        Guest city = cityRepository.findById(id).orElse(null);
//        if (city != null) {
//            city.setGuestName(updatedGuest.getGuestName());
//            city.setRegion(updatedGuest.getRegion());
//            // Add any other fields you want to update
//            return cityRepository.save(city);
//        }
//        return null;
//    }
    public String deleteGuest(Long id){
        guestRepo.deleteById(id);
        return "Guest with id " + id + " was deleted";
    }
}
