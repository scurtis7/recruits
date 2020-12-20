package com.scurtis.recruits.exceptions;

/**
 * Author: Steve Curtis
 * Date: Dec 19, 2020
 **/

public class FailedLoginException extends RuntimeException {
    public FailedLoginException(String message) {
        super(message);
    }
}
