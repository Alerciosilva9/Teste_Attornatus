package com.attornatus.avaliacao.apiAttornatus.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

@RestControllerAdvice
public class PessoaControllerException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public List<ErrorHandler> handle(MethodArgumentNotValidException exception){
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        List<ErrorHandler>  errorHandlers = new ArrayList<>();

        fieldErrors.forEach(error -> errorHandlers.add(new ErrorHandler(error.getField(),error.getDefaultMessage())));

        return errorHandlers;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ErrorHandler ArgumentoNaoValido(IllegalArgumentException e){
        return new ErrorHandler(e.getMessage(),e.getLocalizedMessage());
    }


}
