package Majorpiece.bringstock.domain.auth.controller;

import Majorpiece.bringstock.domain.auth.dto.request.SignupRequest;
import Majorpiece.bringstock.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest signupRequest){

        authService.signup(signupRequest);

        return ResponseEntity.ok("Signup successful");
    }
}
