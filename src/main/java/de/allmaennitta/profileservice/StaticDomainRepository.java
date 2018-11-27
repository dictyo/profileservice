package de.allmaennitta.profileservice;

import de.allmaennitta.model.generated.Domain;

import javax.annotation.PostConstruct;

class StaticDomainRepository implements DomainRepository {
  @PostConstruct
  void init(){

  }

  @Override
  public Domain findById(String domainName) {
    return null;
  }
}