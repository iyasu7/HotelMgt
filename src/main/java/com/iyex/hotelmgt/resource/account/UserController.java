package com.iyex.hotelmgt.resource.account;

import com.iyex.hotelmgt.domain.Hotel;
import com.iyex.hotelmgt.domain.account.User;
import com.iyex.hotelmgt.domain.account.UserType;
import com.iyex.hotelmgt.service.HotelService;
import com.iyex.hotelmgt.service.account.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    public final UserService userService;
    public final HotelService hotelService;

        @GetMapping("/{id}")
        public User getUser(@PathVariable Long id){
                return userService.getUser(id);
        }
        @GetMapping("/employees")
        public Set<User> getEmployees(){
            return userService.getUsersByUserType(UserType.EMPLOYEE);
        }
        @GetMapping("/guests")
        public Set<User> getGuests(){
            return userService.getUsersByUserType(UserType.GUEST);
        }
        @GetMapping("/guests/{id}")
        public Set<User> getEmployeesByHotel(@PathVariable Long id){
            Hotel hotel = hotelService.getHotel(id);
            return userService.getUsersByHotel(hotel);
        }
        @GetMapping
        public List<User> getAllUsers(){
                return userService.getAllUser();
        }
        @PostMapping
        public User createUser(@RequestBody User user){
                return userService.saveUser(user);
        }
        @DeleteMapping("/{id}")
        public String deleteUser(@PathVariable Long id){
                return userService.deleteUser(id);
            }
        }
