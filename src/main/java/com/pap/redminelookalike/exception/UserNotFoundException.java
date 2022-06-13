package com.pap.redminelookalike.exception;


import lombok.Getter;

public class UserNotFoundException extends RuntimeException {

    @Getter
    private Long id;

    public UserNotFoundException(Long id) {
        this.id = id;
    }
}
