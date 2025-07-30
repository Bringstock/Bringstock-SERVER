package Majorpiece.bringstock.global.security.service;

import Majorpiece.bringstock.domain.user.domain.User;
import Majorpiece.bringstock.domain.user.domain.repository.UserRepository;
import Majorpiece.bringstock.domain.user.exception.UserNotFoundException;
import Majorpiece.bringstock.global.security.dto.OAuthAttributes;
import Majorpiece.bringstock.global.security.vo.CustomUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("loadUser");

        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        log.info("Google userNameAttributeName = {}", userNameAttributeName);


        OAuthAttributes attributes = OAuthAttributes.ofGoogle(userNameAttributeName, oAuth2User.getAttributes());

        String name = attributes.getName() != null ? attributes.getName() : "";
        String email = attributes.getEmail() != null ? attributes.getEmail() : "";
        String picture = attributes.getPicture();
        String id = attributes.getId();
        String socialType = "google";

        log.info("Google 로그인 사용자 정보: name={}, email={}, id={}", name, email, id);

        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));

        String username = email;
        String authProvider = socialType;
        User user;

        if (!userRepository.existsByUsername(username)) {
            user = User.builder()
                    .username(username)
                    .authProvider(authProvider)
                    .build();
            user = userRepository.save(user);
        } else {
            user = userRepository.findByUsername(username)
                    .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        }

        log.info("회원 조회/생성 완료: username={}, provider={}", username, authProvider);

        return new CustomUser(user.getId(), email, name, authorities, attributes);
    }
}
