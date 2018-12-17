package de.allmaennitta.profileservice.domain;

import de.allmaennitta.profileservice.model.Category;
import java.util.List;

public interface DomainRepository {
  public List<Category> findById(String domainName);
}