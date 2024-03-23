package com.morozik.clientinformation.exception;

import com.morozik.clientinformation.model.enums.ExceptionCode;
import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {

    private final ExceptionCode code;

    public ApplicationException(String message, ExceptionCode code) {
        super(message);
        this.code = code;
    }
}
