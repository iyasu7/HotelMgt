package com.iyex.hotelmgt.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iyex.hotelmgt.config.JwtService;
import com.iyex.hotelmgt.domain.account.Confirmation;
import com.iyex.hotelmgt.domain.account.User;
import com.iyex.hotelmgt.domain.account.UserType;
import com.iyex.hotelmgt.repository.account.ConfirmationRepo;
import com.iyex.hotelmgt.repository.account.RoleRepo;
import com.iyex.hotelmgt.repository.account.UserRepo;
import com.iyex.hotelmgt.service.EmailService;
import com.iyex.hotelmgt.token.Token;
import com.iyex.hotelmgt.token.TokenRepo;
import com.iyex.hotelmgt.token.TokenType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepo roleRepo;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TokenRepo tokenRepo;
    private final ConfirmationRepo confirmationRepo;
    private final EmailService emailService;

    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(roleRepo.findByRoleName("guest"))
                .userType(UserType.GUEST)
                .build();

        user.setEnable(false);

        userRepo.save(user);

        Confirmation confirmation = new Confirmation(user);
        confirmationRepo.save(confirmation);

        emailService.sendTextMailMessage(user.getFirstName()+" "+user.getLastName(),user.getUsername(),confirmation.getConfirmationLink());
        //Email


        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveToken(user, jwtToken);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
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
        var user = userRepo.findUserByUsernameIgnoreCase(request.getUsername());
        if (user == null) {
            throw new NoSuchElementException("user with username: "+request.getUsername()+" NOT found!!");
        }
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserToken(user);
        saveToken(user,jwtToken);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }
    public void revokeAllUserToken(User user){
        var validUserTokens = tokenRepo.findAllValidTokensByUserId(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(t -> {
            t.setExpired(true);
            t.setRevoked(true);
        });
        tokenRepo.saveAll(validUserTokens);
    }

    private void saveToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();

        tokenRepo.save(token);
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken ;
        final String username;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        username = jwtService.extractUsername(refreshToken);
        if (username != null) {
            var userDetails = userRepo.findUserByUsernameIgnoreCase(username);
            if (userDetails == null) {
                throw new NoSuchElementException("user not found");
            }
            if (jwtService.isTokenValid(refreshToken,userDetails)){
                var accessToken = jwtService.generateToken(userDetails);
                revokeAllUserToken(userDetails);
                saveToken(userDetails,accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
            new ObjectMapper().writeValue(response.getOutputStream(),authResponse);
            }

        }

    }
        public Boolean verifyLink(String confirmLink){
            Confirmation confirmation = confirmationRepo.findByConfirmationLink(confirmLink);
            if (confirmation == null) {
                throw new NoSuchElementException("NO confirmation with this confirmation Link");
            }
            User user = userRepo.findUserByUsernameIgnoreCase(confirmation.getUser().getUsername());
            if (user == null) {
                throw new NoSuchElementException("User with this confirmation NOT FOUND ");
            }
            user.setEnable(true);
            userRepo.save(user);
            return true;
        }
}
