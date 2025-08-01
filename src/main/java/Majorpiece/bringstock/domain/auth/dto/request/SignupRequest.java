package Majorpiece.bringstock.domain.auth.dto.request;

public record SignupRequest (
    String username,
    String password,
    String email
){}
