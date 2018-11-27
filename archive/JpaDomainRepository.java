package de.allmaennitta.profileservice;

import de.allmaennitta.model.generated.Domain;
import org.springframework.data.repository.CrudRepository;

interface JpaDomainRepository extends CrudRepository<Domain, String> {
}