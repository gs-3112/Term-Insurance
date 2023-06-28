package com.ti.exception;


import com.ti.util.Errors;
import com.ti.util.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestControllerAdvice
public class ApplicationExceptionHandler {

    @Value("${service.name}")
    private String serviceName;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<Errors> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        
       return buildCustomError(errorMap,HttpStatus.BAD_REQUEST);
    }

    private List<Errors> buildCustomError(Map<String, String> errorMap,HttpStatus status){
        Errors errors = Errors.builder()
                .source(serviceName.translateEscapes())
                .errorCode(1000)
                .statusCode(status.value())
                .status(status.name())
                .message(errorMap.entrySet().stream().map(entry-> Message.builder().field(entry.getKey()).message(entry.getValue()).build()).collect(Collectors.toList()))
                .build();
        return List.of(errors);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public List<Errors> handleBusinessException(Exception ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getLocalizedMessage());
        return buildCustomError(errorMap,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}