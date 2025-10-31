package com.wesovilabs.festify.util.exception;

public class AlbumNotFoundException extends RuntimeException {
    public AlbumNotFoundException(String message) {
        super(message);
    }
}
