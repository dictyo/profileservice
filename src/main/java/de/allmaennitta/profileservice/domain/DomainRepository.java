package de.allmaennitta.profileservice.domain;

import de.allmaennitta.model.generated.Domain;
import java.util.Optional;

public interface DomainRepository {
  public Optional<Domain> findById(String domainName);
}