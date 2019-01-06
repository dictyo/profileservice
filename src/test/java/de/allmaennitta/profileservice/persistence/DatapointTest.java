package de.allmaennitta.profileservice.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import de.allmaennitta.profileservice.model.Experience;
import de.allmaennitta.profileservice.model.Focus;
import de.allmaennitta.profileservice.model.Skill;
import de.allmaennitta.profileservice.skill.JpaExperienceRepository;
import de.allmaennitta.profileservice.skill.JpaSkillRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:application.properties")
@Slf4j
public class DatapointTest {

  @Autowired
  private JpaExperienceRepository experienceRepository;

  @Autowired
  private JpaSkillRepository skillRepository;

  @Test
  public void testSaveSingleExperience() {
    Experience toBeSaved = new Experience();
    toBeSaved.setValue(1);
    toBeSaved.setCorrection(-0.3d);

    Experience withId = experienceRepository.save(toBeSaved);
    Optional<Experience> result = experienceRepository.findById(withId.getId());
    log.info("EXP: "+result.toString());
    assertThat(result.isPresent()).isTrue();
    assertThat(result.get()).isEqualTo(toBeSaved);
  }

  @Test
  public void testSaveSkillWithDatapoints() {
    Experience exp = new Experience();
    exp.setValue(1);
    exp.setCorrection(-0.3d);

    Focus focus = new Focus();
    focus.setValue(3);
    focus.setCorrection(0.2d);

    Skill skill = new Skill();
    skill.setName("x");
    skill.setDomain("y");
    skill.setCategory("z");
    skill.setExperience(exp);
    skill.setFocus(focus);
    log.info("SKILL initial: {}",skill);

    skillRepository.save(skill);
    Optional<Skill> result = skillRepository.findById(skill.getName());
    log.info("SKILL fetched: {}",result.toString());
    assertThat(result.isPresent()).isTrue();
    assertThat(result.get()).isEqualTo(skill);
  }


}
