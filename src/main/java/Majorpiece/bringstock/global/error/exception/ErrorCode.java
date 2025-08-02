package Majorpiece.bringstock.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // ===== JWT =====
    EXPIRED_JWT_TOKEN(401, "JWT-401-1", "Expired JWT Token"),
    INVALID_JWT_TOKEN(401, "JWT-401-2", "Invalid JWT Token"),

    // ===== USER =====
    USER_NOT_FOUND(404, "USER-404-1","User Not Found"),
    DUPLICATE_USER(409, "USER-409-1", "Duplicate User"),

    // ===== AUTH =====
    LOGIN_FAILED(401, "AUTH-401-1", "Invalid username or password"),

    // ===== SERVER =====
    INTERNAL_SERVER_ERROR(500, "SERVER-500-1", "Internal server error");

    private final int status;
    private final String code;
    private final String message;
}
