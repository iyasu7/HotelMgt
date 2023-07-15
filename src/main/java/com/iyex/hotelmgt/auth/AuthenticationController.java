package com.iyex.hotelmgt.auth;

import com.iyex.hotelmgt.domain.http.HttpResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){

        return ResponseEntity.ok(authenticationService.register(request));
//        FOR FUTURE USE
//        return ResponseEntity.created(URI.create("")).body(
//                HttpResponse.builder()
//                        .timeStamp(LocalDateTime.now().toString())
//                        .data(Map.of("user",user))
//                        .message("User created")
//                        .status(HttpStatus.CREATED)
//                        .statusCode(HttpStatus.CREATED.value()))
//                        .build();
//        )

    }
    //    @PostMapping("employees/register")
//    public ResponseEntity<AuthenticationResponse> registerEmployee(
//            @RequestBody RegisterEmployeeRequest request
//    ){
//
//        return ResponseEntity.ok(authenticationService.registerEmployee(request));
//    }
    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){

        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
    @PostMapping("refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        authenticationService.refreshToken(request,response);
    }
    @GetMapping
    public ResponseEntity<HttpResponse> confirmUserAccount(@RequestParam("confirmLink") String confirmLink){
        Boolean isSuccess = authenticationService.verifyLink(confirmLink);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("Success",isSuccess))
                        .message("Account Confirmed successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
}
