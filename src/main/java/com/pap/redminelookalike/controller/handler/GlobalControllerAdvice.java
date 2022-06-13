package com.pap.redminelookalike.controller.handler;

import com.pap.redminelookalike.controller.handler.dto.ErrorMessageDto;
import com.pap.redminelookalike.exception.UserFoundException;
import com.pap.redminelookalike.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorMessageDto errorMessageDto(UserNotFoundException userNotFoundException) {
        return new ErrorMessageDto(
                "Пользователь с id=" + userNotFoundException.getId() + " не найден"
        );
    }

    @ExceptionHandler(UserFoundException.class)
    public ErrorMessageDto catchRuntimeException(UserFoundException userFoundException) {
        return new ErrorMessageDto("Логин " + userFoundException.getLogin() + " занят");
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ErrorMessageDto catchRuntimeException() {
//        return new ErrorMessageDto("ERROR");
//    }
}
