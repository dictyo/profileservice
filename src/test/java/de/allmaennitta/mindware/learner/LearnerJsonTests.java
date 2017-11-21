package de.allmaennitta.mindware.learner;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

@JsonTest
@RunWith(SpringRunner.class)
public class LearnerJsonTests {

  @Autowired
  private JacksonTester<Learner> json;

  @Test
  public void testSerialize() throws Exception {
    Learner details = new Learner("kalle", "lehrer", 1966);
    assertThat(this.json.write(details)).hasJsonPathNumberValue("@.birthyear");
    assertThat(this.json.write(details)).isEqualToJson("{'name': 'kalle','profession':'lehrer', 'birthyear': 1966}");
    assertThat(this.json.write(details)).extractingJsonPathStringValue("@.profession").contains("rer");
  }

  @Test
  public void testDeserialize() throws Exception {
    String content = "{\"name\":\"Ursula\",\"profession\":\"Tiefbauingenieur\",\"birthyear\":\"1944\"}";
    assertThat(this.json.parse(content))
        .isEqualTo(new Learner("Ursula", "Tiefbauingenieur", 1944));
    assertThat(this.json.parseObject(content).getBirthyear()).isEqualTo(1944);
  }

  @Test
  public void multiplicationOfZeroIntegersShouldReturnZero() {
    assertThat("a").as("test context").isEqualTo("a");
  }


}