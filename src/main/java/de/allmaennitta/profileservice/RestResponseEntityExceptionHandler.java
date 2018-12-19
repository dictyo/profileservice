package de.allmaennitta.profileservice;

import de.allmaennitta.profileservice.domain.NonExistentDomainIdException;
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

  @ExceptionHandler(value = { NonExistentDomainIdException.class })
  protected ResponseEntity<Object> handleConflict(
      RuntimeException ex, WebRequest request) {
    Map bodyOfResponse = Collections.singletonMap("code",ex.getMessage());
    return handleExceptionInternal(ex, bodyOfResponse,
        new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }

  @ExceptionHandler(value = { InvalidSkillException.class})
  protected ResponseEntity<Object> handleInvalidPost(RuntimeException ex, WebRequest request) {
    InvalidSkillException invalidSkillException = (InvalidSkillException) ex;

    Map<String, Map<String, Object>> bodyOfResponse = Collections.singletonMap("code",
        invalidSkillException.getBindingResult().getModel());

    return handleExceptionInternal(ex, bodyOfResponse,
        new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }

}