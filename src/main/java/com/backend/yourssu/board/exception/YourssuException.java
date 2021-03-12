package com.backend.yourssu.board.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class YourssuException extends RuntimeException {
    protected HttpStatus status;
    protected ErrorEnum errorEnum;

    public YourssuException(ErrorEnum errorEnum) {
        super(errorEnum.toString());
        this.status = errorEnum.getErrorResponse().getHttpStatus();
        this.errorEnum = errorEnum;
    }
    public YourssuException(ErrorEnum errorEnum, List<Long> concatMessage) {
        super(errorEnum.toString());
        this.status = errorEnum.getErrorResponse().getHttpStatus();
        this.errorEnum = errorEnum;
        this.errorEnum.getErrorResponse().setMessage(concatMessage + " " + errorEnum.getMessage());
    }

    public YourssuException(ErrorEnum errorEnum, String concatMessage) {
        super(errorEnum.toString());
        this.status = errorEnum.getErrorResponse().getHttpStatus();
        this.errorEnum = errorEnum;
        this.errorEnum.getErrorResponse().setMessage(concatMessage + " " + errorEnum.getMessage());
    }
}
