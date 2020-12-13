package com.scurtis.recruits.exceptions;

/**
 * Author: Steve Curtis
 * Date: Dec 13, 2020
 **/

public class DuplicateUsernameException extends RuntimeException {
    public DuplicateUsernameException(String message, Throwable cause) {
        super(message, cause);
    }
}
