package de.allmaennitta.profileservice;

import de.allmaennitta.profileservice.skill.InvalidSkillException;
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

  @ExceptionHandler(value = { EntityNotFoundException.class})
  protected ResponseEntity<Object> handleWrongDomain(
      RuntimeException ex, WebRequest request) {
    Map bodyOfResponse = Collections.singletonMap("code",ex.getMessage());
    return handleExceptionInternal(ex, bodyOfResponse,
        new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }
  @ExceptionHandler(value = { InvalidSkillException.class })
  protected ResponseEntity<Object> handleSkillError(
      RuntimeException ex, WebRequest request) {
    Map bodyOfResponse = Collections.singletonMap("code",ex.getMessage());
    return handleExceptionInternal(ex, bodyOfResponse,
        new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }
}
