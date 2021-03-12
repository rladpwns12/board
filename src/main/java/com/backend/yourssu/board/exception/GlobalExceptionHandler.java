package com.backend.yourssu.board.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({YourssuException.class})
    public ResponseEntity<ErrorEnum.ErrorResponse> handleYourssuException(HttpServletRequest request, HttpServletResponse response, YourssuException ex) throws IOException {
        ErrorEnum errorEnum = ex.getErrorEnum();
        logger.error("유어슈 오류 감지. - Enum : {}", errorEnum, ex);
        ErrorEnum.ErrorResponse errorResponse = errorEnum.getErrorResponse();
        return new ResponseEntity<>(errorResponse, errorEnum.getHttpStatus());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorEnum.ErrorResponse> handleException(HttpServletRequest request, HttpServletResponse response, Exception ex) throws IOException {
        ex.printStackTrace();
        logger.error("알 수 없는 오류 감지.", ex);
        return handleYourssuException(request, response, new YourssuException(ErrorEnum.ETC));
    }


}
