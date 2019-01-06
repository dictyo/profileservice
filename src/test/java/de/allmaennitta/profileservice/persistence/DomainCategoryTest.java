package de.allmaennitta.profileservice.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import de.allmaennitta.profileservice.model.Category;
import de.allmaennitta.profileservice.model.Domain;
import de.allmaennitta.profileservice.model.Experience;
import de.allmaennitta.profileservice.model.Focus;
import de.allmaennitta.profileservice.model.Skill;
import de.allmaennitta.profileservice.skill.JpaExperienceRepository;
import de.allmaennitta.profileservice.skill.JpaSkillRepository;
import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:application.properties")
@Slf4j
public class DomainCategoryTest {

  @Autowired
  private EntityManager em;

  @Test
  public void testSaveSkillWithDatapoints() {
   // TODO test domain
  }


}
