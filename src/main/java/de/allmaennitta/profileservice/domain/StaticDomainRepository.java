package de.allmaennitta.profileservice.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.allmaennitta.profileservice.model.Category;
import de.allmaennitta.profileservice.model.Domain;

import de.allmaennitta.profileservice.model.ProfileSchema;
import de.allmaennitta.profileservice.model.Skill;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
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
  void init() {
    try {
      schema = mapper.readValue(profileSchemaJson.getInputStream(),
          ProfileSchema.class);
    } catch (IOException e) {
      throw new IllegalStateException("Something wrong with the profile.json file in "
          + "resources-folder.");
    }
  }

  @Override
  public List<Category> findById(String domainId) {
    Domain domain = schema.getDomains()
        .stream()
        .filter(d -> d.getId().equals(domainId))
        .findFirst()
        .orElseThrow(() ->
            new WrongDomainIdException(String.format("There is no domain called '%s'", domainId)));

    return domain.getCategories().stream()
            .map(c -> {
              List<Skill> skills = schema.getSkills()
                  .stream()
                  .peek(skill -> System.out.println(skill.toString()))
                  .filter(skill -> skill.getDomain().equals(domainId))
                  .filter(skill -> skill.getCategory().equals(c.getId()))
                  .collect(Collectors.toList());
              System.out.println("SKILLS: "+skills);
              c.setSkills(skills);
              return c;
            })
            .collect(Collectors.toList());
  }
}