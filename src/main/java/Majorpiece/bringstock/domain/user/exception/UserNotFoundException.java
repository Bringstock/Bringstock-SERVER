package Majorpiece.bringstock.domain.user.exception;

import Majorpiece.bringstock.global.error.exception.ErrorCode;
import Majorpiece.bringstock.global.error.exception.GlobalException;

public class UserNotFoundException extends GlobalException {
    public static final GlobalException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
