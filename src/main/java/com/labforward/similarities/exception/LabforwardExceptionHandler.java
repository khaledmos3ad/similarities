package com.labforward.similarities.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.labforward.similarities.exception.model.ErrorResponse;

@ControllerAdvice
@ResponseBody
public class LabforwardExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(LabforwardException.class)
  public final ResponseEntity<ErrorResponse> handleScalableException(
      LabforwardException ex, WebRequest request) {
    return new ResponseEntity<>(
        ErrorResponse.builder().error(ex.getMessage()).details(ex.getDetails()).build(),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(NoSuchElementException.class)
  public final ResponseEntity<ErrorResponse> handleNoSuchElementException(
      NoSuchElementException ex, WebRequest request) {
    return new ResponseEntity<>(
        ErrorResponse.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
  }
}
