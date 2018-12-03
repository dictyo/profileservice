package de.allmaennitta.profileservice;

import de.allmaennitta.profileservice.domain.WrongDomainIdException;
import java.util.Collections;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
    extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = { WrongDomainIdException.class })
  protected ResponseEntity<Object> handleConflict(
      RuntimeException ex, WebRequest request) {
    Map bodyOfResponse = Collections.singletonMap("code",ex.getMessage());
    return handleExceptionInternal(ex, bodyOfResponse,
        new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }
}