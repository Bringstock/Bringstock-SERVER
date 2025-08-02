package Majorpiece.bringstock.global.error;

import Majorpiece.bringstock.global.error.exception.ErrorCode;

public record ErrorResponse (

        int status,
        String code,
        String message

    ){
    public ErrorResponse(ErrorCode errorCode) {
        this(
                errorCode.getStatus(),
                errorCode.getCode(),
                errorCode.getMessage()
        );
    }
}
