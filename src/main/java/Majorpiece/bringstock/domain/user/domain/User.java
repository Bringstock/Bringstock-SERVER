package Majorpiece.bringstock.domain.user.domain;

import Majorpiece.bringstock.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user")
@Builder
@AllArgsConstructor
public class User extends BaseEntity {

    private String username;

    private String password;

    private String profile;

    @Column(unique = true)
    private String email;

    private String authProvider;
}
