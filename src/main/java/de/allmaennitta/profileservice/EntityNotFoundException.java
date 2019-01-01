package de.allmaennitta.profileservice;

import org.springframework.validation.BindingResult;

public class EntityNotFoundException extends RuntimeException {
  public EntityNotFoundException(String message) {
    super(message);
  }
}
