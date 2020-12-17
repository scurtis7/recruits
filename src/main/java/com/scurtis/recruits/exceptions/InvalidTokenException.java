package com.scurtis.recruits.exceptions;

/**
 * Author: Steve Curtis
 * Date: Dec 16, 2020
 **/

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException(String message) {
        super(message);
    }
}
