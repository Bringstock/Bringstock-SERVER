package Majorpiece.bringstock.domain.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignupRequest (
        @Size(min = 1, max = 15, message = "아이디는 최소 1자 이상, 최대 15자 이하여야 합니다.")
        @NotBlank(message = "아이디는 필수입니다.")
        String username,

        @Size(min = 8,  max = 20, message = "비밀번호는 최소 8자 이상, 최대 20자 이하여야 합니다.")
        @NotBlank(message = "비밀번호는 필수입니다.")
        String password,

        @Size(min = 11, max = 255, message = "이메일은 최소 11자 이상, 최대 255자 이하여야 합니다.")
        @Email(message = "이메일 형식이 올바르지 않습니다.")
        String email
){}
