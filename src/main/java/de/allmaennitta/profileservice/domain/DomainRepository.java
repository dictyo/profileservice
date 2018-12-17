package de.allmaennitta.profileservice.domain;

import de.allmaennitta.profileservice.model.Domain;
import java.util.Optional;

public interface DomainRepository {
  public Optional<Domain> findById(String domainName);
}