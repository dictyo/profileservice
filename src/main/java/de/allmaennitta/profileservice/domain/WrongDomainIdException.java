package de.allmaennitta.profileservice.domain;

public class WrongDomainIdException extends RuntimeException {
  public WrongDomainIdException(String message) {
    super(message);
  }
}
