package Majorpiece.bringstock.domain.auth.service;

import Majorpiece.bringstock.domain.auth.dto.request.LoginRequest;
import Majorpiece.bringstock.domain.auth.dto.request.SignupRequest;
import Majorpiece.bringstock.domain.user.domain.User;
import Majorpiece.bringstock.domain.user.domain.repository.UserRepository;
import Majorpiece.bringstock.domain.user.exception.DuplicateUserException;
import Majorpiece.bringstock.domain.user.exception.UserNotFoundException;
import Majorpiece.bringstock.global.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public void signup(SignupRequest signupRequest) {
        if(userRepository.existsByEmail(signupRequest.email())){
            throw DuplicateUserException.EXCEPTION;
        }

        User user = User.builder()
                .username(signupRequest.username())
                .password(passwordEncoder.encode(signupRequest.password()))
                .email(signupRequest.email())
                .authProvider("local")
                .build();

        userRepository.save(user);
    }

    public String login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.username())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(loginRequest.password(), user.getPassword())) {
            throw UserNotFoundException.EXCEPTION;
        }

        return tokenProvider.create(user);
    }
}
