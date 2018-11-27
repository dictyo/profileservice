package de.allmaennitta.profileservice;

import de.allmaennitta.model.generated.Domain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

interface DomainRepository {
  public Domain findById(String domainName);
}