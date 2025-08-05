package Majorpiece.bringstock.domain.user.service;

import Majorpiece.bringstock.domain.user.domain.User;
import Majorpiece.bringstock.domain.user.dto.response.UserProfileResponse;
import Majorpiece.bringstock.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFacade userFacade;

    public UserProfileResponse getUserProfile(UserFacade userFacade) {
        User user = userFacade.getCurrentUser();

        return new UserProfileResponse(user);
    }
}
