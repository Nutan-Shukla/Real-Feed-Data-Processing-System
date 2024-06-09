package com.example.Spring.exception.handler;

import com.example.Spring.exception.*;
import com.example.Spring.protos.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = {UserNotFoundException.class})
    protected ApiResponse handleUserNotFoundException(UserNotFoundException ex) {
        return ApiResponse.newBuilder().setMsg(ex.getMessage()).setStatus("401").build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {InsufficientBalanceException.class})
    protected ApiResponse handleUserBalanceIsNotSufficient(InsufficientBalanceException ex) {
        return ApiResponse.newBuilder().setMsg(ex.getMessage()).setStatus("400").build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {InsufficientQuantityException.class})
    protected ApiResponse handleUserGoldIsNotSufficient(InsufficientQuantityException ex) {
        return ApiResponse.newBuilder().setMsg(ex.getMessage()).setStatus("400").build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {UserAlreadyFoundException.class})
    protected ApiResponse handleUserGoldIsNotSufficient(UserAlreadyFoundException ex) {
        return ApiResponse.newBuilder().setMsg(ex.getMessage()).setStatus("400").build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {IncorrectUserBodyException.class})
    protected ApiResponse handleCheckUserBody(IncorrectUserBodyException userBody) {

        return ApiResponse.newBuilder().setMsg(userBody.getMessage()).setStatus("400").build();

    }
}
