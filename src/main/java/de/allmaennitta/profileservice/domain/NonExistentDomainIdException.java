package de.allmaennitta.profileservice.domain;

public class NonExistentDomainIdException extends RuntimeException {
  public NonExistentDomainIdException(String message) {
    super(message);
  }
}
