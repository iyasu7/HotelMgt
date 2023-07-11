package com.iyex.hotelmgt.auth;

import com.iyex.hotelmgt.config.JwtService;
import com.iyex.hotelmgt.domain.account.User;
import com.iyex.hotelmgt.repository.account.RoleRepo;
import com.iyex.hotelmgt.repository.account.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepo roleRepo;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(roleRepo.findByRoleName("guest"))
                .build();

        userRepo.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
//    public AuthenticationResponse registerEmployee(RegisterEmployeeRequest request) {
//        Employee employee = (Employee) User.builder()
//                .firstName(request.getFirstName())
//                .lastName(request.getLastName())
//                .username(request.getUsername())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .role(roleRepo.findByRoleName(request.getRole()))
//                .
//                .build();
//        employeeRepo.save(employee);
//        var jwtToken = jwtService.generateToken(employee);
//
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
//    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),request.getPassword()));
        var user = userRepo.findUserByUsername(request.getUsername());
        if (user == null) {
            throw new NoSuchElementException("user with username: "+request.getUsername()+" NOT found!!");
        }
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
