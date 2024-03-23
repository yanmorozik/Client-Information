package com.morozik.clientinformation.exception;

import com.morozik.clientinformation.model.enums.ExceptionCode;

public class NotFoundException extends ApplicationException {
    public NotFoundException(String message, ExceptionCode code) {
        super(message, code);
    }
}
