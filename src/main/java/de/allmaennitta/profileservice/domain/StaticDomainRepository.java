package de.allmaennitta.profileservice.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.allmaennitta.model.generated.Domain;

import de.allmaennitta.model.generated.ProfileSchema;
import java.io.IOException;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

public class StaticDomainRepository implements DomainRepository {

  @Autowired
  ObjectMapper mapper;

  @Value(value = "classpath:profile.json")
  private Resource profileSchemaJson;

  private ProfileSchema schema;

  @PostConstruct
  void init(){
    try {
       schema = mapper.readValue(profileSchemaJson.getInputStream(),
          ProfileSchema.class);
    } catch (IOException e) {
      throw new IllegalStateException("Something wrong with the profile.json file in "
          + "resources-folder.");
    }
  }

  @Override
  public Optional<Domain> findById(String domainId) {
    return schema.getDomains()
        .stream()
        .filter(d -> d.getId().equals(domainId))
        .findFirst();
  }
}