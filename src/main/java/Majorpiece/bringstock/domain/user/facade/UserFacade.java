package Majorpiece.bringstock.domain.user.facade;

import Majorpiece.bringstock.domain.user.domain.User;
import Majorpiece.bringstock.domain.user.domain.repository.UserRepository;
import Majorpiece.bringstock.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {

        String userIdStr = (String) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        Long userId = Long.parseLong(userIdStr);

        return getUserById(userId);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }
}
