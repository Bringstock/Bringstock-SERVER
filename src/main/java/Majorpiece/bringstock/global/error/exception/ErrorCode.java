package Majorpiece.bringstock.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(500, "Internal server error");

    private final int status;
    private final String message;
}
