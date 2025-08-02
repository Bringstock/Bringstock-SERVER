package Majorpiece.bringstock.domain.user.exception;

import Majorpiece.bringstock.global.error.exception.ErrorCode;
import Majorpiece.bringstock.global.error.exception.GlobalException;

public class DuplicateUserException extends GlobalException {
    public static final GlobalException EXCEPTION = new DuplicateUserException();

    public DuplicateUserException() {super(ErrorCode.DUPLICATE_USER);}
}
