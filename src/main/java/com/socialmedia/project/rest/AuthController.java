package com.socialmedia.project.rest;

import com.socialmedia.project.dto.LoginDto;
import com.socialmedia.project.dto.SignUpDto;
import com.socialmedia.project.service.RegistrationService;
import com.socialmedia.project.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;
    private final RegistrationService registrationService;
    private final AuthenticationManager authenticationManager;

    public AuthController(UserService service, RegistrationService registrationService, AuthenticationManager authenticationManager) {
        this.service = service;
        this.registrationService = registrationService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User login successfully!...", HttpStatus.OK);
    }

    @PostMapping("/registration")
    public void registerUser(@RequestBody SignUpDto signUpDto) {
        registrationService.register(signUpDto);
    }

}
