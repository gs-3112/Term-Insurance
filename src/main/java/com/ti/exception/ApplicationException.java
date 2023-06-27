package com.ti.exception;

import java.text.MessageFormat;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationException extends RuntimeException {
    private HttpStatus status;

    public ApplicationException(HttpStatus status, String pattern, Object... params) {
        super(MessageFormat.format(pattern, params));
        this.status = status;
    }

    ApplicationException(HttpStatus status, String pattern, Throwable cause, Object... params) {
        super(MessageFormat.format(pattern, params), cause);
        this.status = status;
    }
}
