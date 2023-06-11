package com.service.service.exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.service.service.Util.CommonUtil;
import com.service.service.Util.response.ErrorResponse;
import com.service.service.Util.response.ResponseUtils;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ValidationException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseUtils> handleValidationException(MethodArgumentNotValidException ex,
            HttpServletRequest request)
            throws JsonProcessingException {
        String path = request.getRequestURI().replaceFirst("/", "");

        List<ErrorResponse> listError = new ArrayList<>();
        if (!ex.getFieldErrors().isEmpty()) {
            Map fieldErrorExists = new HashMap();
            for (FieldError fieldError : ex.getFieldErrors()) {
                if (!fieldErrorExists.containsKey(fieldError.getField())) {
                    ErrorResponse errorResponse = new ErrorResponse();
                    errorResponse.setField(fieldError.getField());
                    errorResponse.setMsg(fieldError.getDefaultMessage());
                    listError.add(errorResponse);
                }
                fieldErrorExists.put(fieldError.getField(), fieldError.getField());
            }
        }

        // Return a JSON response with the error details and appropriate HTTP status
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        CommonUtil.getInstance().setGeneralResponse(
                                null,
                                path,
                                null,
                                "There is an Error",
                                listError,
                                null,
                                null,
                                null));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseUtils> handleMissingServletRequestParameterException(
            HttpMessageNotReadableException ex, HttpServletRequest request) throws IOException {

        System.out.println("<<<<< " + ex.getLocalizedMessage());
        System.out.println("<<<<< " + ex.getMessage());
        System.out.println("<<<<< " + ex.getHttpInputMessage().getBody().toString());
        String path = request.getRequestURI().replaceFirst("/", "");
        String errorMessage = "Required request body is missing.";
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        CommonUtil.getInstance().setGeneralResponse(
                                null,
                                path,
                                null,
                                "There is an Error",
                                errorMessage,
                                null,
                                null, 
                                null));
    }
}
