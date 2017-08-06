package com.hasith.sample.exception;

/**
 * Created by hasith on 8/5/2017.
 */
public class SampleException extends RuntimeException{

    public SampleException(String message) {
        super(message);
    }

    public SampleException(String message, Throwable cause) {
        super(message, cause);
    }
}
