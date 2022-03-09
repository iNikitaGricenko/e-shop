package com.wolfhack.diploma.exception.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Map;

import static org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import static java.util.stream.Collectors.toList;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, List<String>> allErrors = Map.of("errors", exception.getBindingResult()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(toList())
        );
        return handleExceptionInternal(exception, allErrors, headers, status, request);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleEmailExists(
            NotFoundException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String bodyMessage = exception.getMessage();
        return handleExceptionInternal(exception, bodyMessage, headers, status, request);
    }

}
