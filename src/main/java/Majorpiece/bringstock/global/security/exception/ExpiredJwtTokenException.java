package Majorpiece.bringstock.global.security.exception;

import Majorpiece.bringstock.global.error.exception.ErrorCode;
import Majorpiece.bringstock.global.error.exception.GlobalException;

public class ExpiredJwtTokenException extends GlobalException {
    public static final GlobalException EXCEPTION = new ExpiredJwtTokenException();

    private ExpiredJwtTokenException() {
        super(ErrorCode.EXPIRED_JWT_TOKEN);
    }
}