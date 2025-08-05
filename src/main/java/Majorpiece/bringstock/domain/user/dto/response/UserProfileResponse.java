package Majorpiece.bringstock.domain.user.dto.response;

import Majorpiece.bringstock.domain.user.domain.User;

public record UserProfileResponse (
        String email,
        String username,
        String profile
){
    public UserProfileResponse(User user) {
        this(
                user.getEmail(),
                user.getUsername(),
                user.getProfile()
        );
    }
}
