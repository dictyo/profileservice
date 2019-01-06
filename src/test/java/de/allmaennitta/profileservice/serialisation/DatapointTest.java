package de.allmaennitta.profileservice.serialisation;

import static org.assertj.core.api.Assertions.assertThat;

import de.allmaennitta.profileservice.configuration.ModelConfiguration;
import de.allmaennitta.profileservice.model.Experience;
import de.allmaennitta.profileservice.model.Focus;
import de.allmaennitta.profileservice.model.Skill;
import java.net.URI;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@JsonTest
@ContextConfiguration(classes = {ModelConfiguration.class})
@Slf4j
public class DatapointTest {

  @Autowired
  private JacksonTester<Skill> json;

  @Test
  public void testConstruction() {
    Experience e = new Experience();
    e.setValue(1);
    Focus f = new Focus();
    f.setValue(1);

    Skill s = new Skill();
    s.setName("x");
    s.setDomain("y");
    s.setCategory("z");
    s.setExperience(e);
    s.setFocus(f);

    assertThat(s.getExperience().getValue()).isEqualTo(1);
    assertThat(s.getDomain()).isEqualTo("y");
  }

  @Test
  public void testSerialize() throws Exception {
    Experience e = new Experience();
    e.setValue(1);
    Focus f = new Focus();
    f.setValue(1);

    Skill s = new Skill();
    s.setName("x");
    s.setDomain("y");
    s.setCategory("z");
    s.setExperience(e);
    s.setFocus(f);

    JsonContent<Skill> out = this.json.write(s);
    log.info("JSON: " + out.getJson());
    assertThat(out).hasJsonPathStringValue("@.domain");
    assertThat(out).extractingJsonPathStringValue("@.domain").isEqualTo("y");
  }

  @Test
  public void testDeserialize() throws Exception {
    Experience e = new Experience();
    e.setValue(2);
    e.setCorrection(0.3d);
    Focus f = new Focus();
    f.setValue(3);
    f.setCorrection(-0.3d);

    Skill expected = new Skill();
    expected.setName("x");
    expected.setDomain("y");
    expected.setCategory("z");
    expected.setExperience(e);
    expected.setFocus(f);

    URI uri = getClass().getResource("skill.json").toURI();
    log.info("URI: "+uri.toString());
    assertThat(this.json.read(getClass().getResourceAsStream("skill.json"))).isEqualTo(expected);
  }
}
