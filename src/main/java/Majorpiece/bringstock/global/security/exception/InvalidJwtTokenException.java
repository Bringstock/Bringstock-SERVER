package Majorpiece.bringstock.global.security.exception;

import Majorpiece.bringstock.global.error.exception.ErrorCode;
import Majorpiece.bringstock.global.error.exception.GlobalException;

public class InvalidJwtTokenException extends GlobalException {
    public static final GlobalException EXCEPTION = new InvalidJwtTokenException();

    private InvalidJwtTokenException() {
        super(ErrorCode.INVALID_JWT_TOKEN);
    }
}