package Majorpiece.bringstock.domain.auth.exception;

import Majorpiece.bringstock.global.error.exception.ErrorCode;
import Majorpiece.bringstock.global.error.exception.GlobalException;

public class LoginFailedException extends GlobalException {
    public static final GlobalException EXCEPTION = new LoginFailedException();

    public LoginFailedException() {super(ErrorCode.LOGIN_FAILED);}
}
