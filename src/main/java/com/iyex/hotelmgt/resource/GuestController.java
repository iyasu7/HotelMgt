package com.iyex.hotelmgt.resource;

import com.iyex.hotelmgt.domain.Guest;
import com.iyex.hotelmgt.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;
    @GetMapping
    public Page<Guest> getAllGuests(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return guestService.getGuests(pageNumber,pageSize,sortBy);
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable Long id){
        return guestService.getGuestById(id);
    }

    @PostMapping
    public Guest createGuest(@RequestBody Guest guest){
        return guestService.saveGuest(guest);
    }

//    @PutMapping("/{id}")
//    public Guest updateGuest(@RequestBody Guest guest,@PathVariable Long id){
//        return guestService.
//    }
    @DeleteMapping("/{id}")
    public String deleteGuest(@PathVariable Long id){
         return guestService.deleteGuest(id);
    }
}
