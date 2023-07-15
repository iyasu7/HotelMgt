package com.iyex.hotelmgt.service.account;

import com.iyex.hotelmgt.domain.Hotel;
import com.iyex.hotelmgt.domain.account.User;
import com.iyex.hotelmgt.domain.account.UserType;
import com.iyex.hotelmgt.repository.account.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
        private final UserRepo userRepo;

//    public Page<User> getGuests(int pageNumber, int pageSize , String sortBy) {
//
//        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
//        return guestRepo.findAll(pageable);
//    }

        public User getUser(Long id){
                return userRepo.findById(id).orElseThrow(()-> new NoSuchElementException("User with id " + id + " not found"));
        }
        public User getUserByUsername(String username) {
                return userRepo.findUserByUsernameIgnoreCase(username);
            }
        public Set<User> getUsersByUserType(UserType userType){
                    return userRepo.findUserByUserType(userType);
        }
        public Set<User> getUsersByHotel(Hotel hotel){
            return userRepo.findUserByHotel(hotel);
        }

//    public Employee updateEmployee(Long id, Employee employee){
//        return employeeRepo.save(employee);
        public List<User> getAllUser(){
            return userRepo.findAll();
        }

        public User saveUser(User user){
            return userRepo.save(user);
        }

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


    public String deleteUser(Long id){
            userRepo.findById(id).orElseThrow(()-> new NoSuchElementException("User with id " + id + " not found"));
            userRepo.deleteById(id);
            return "User with id " + id + " was Deleted";
    }
}
