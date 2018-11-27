package de.allmaennitta.profileservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@ExtendWith(SpringExtension.class)
public class ProfileJsonTests {

  @Autowired
  private JacksonTester<Profile> json;

  @BeforeEach
  public void setup() {
    ObjectMapper objectMapper = new ObjectMapper();
    JacksonTester.initFields(this, objectMapper);
  }
  @Test
  public void testSerialize() throws Exception {
    Profile details = new Profile("kalle", "lehrer", 1966);
    assertThat(this.json.write(details)).hasJsonPathNumberValue("@.birthyear");
    assertThat(this.json.write(details)).isEqualToJson("{'name': 'kalle','profession':'lehrer', 'birthyear': 1966}");
    assertThat(this.json.write(details)).extractingJsonPathStringValue("@.profession").contains("rer");
  }

  @Test
  public void testDeserialize() throws Exception {
    String content = "{\"name\":\"Ursula\",\"profession\":\"Tiefbauingenieur\",\"birthyear\":\"1944\"}";
    assertThat(this.json.parse(content))
        .isEqualTo(new Profile("Ursula", "Tiefbauingenieur", 1944));
    assertThat(this.json.parseObject(content).getBirthyear()).isEqualTo(1944);
  }

  @Test
  public void multiplicationOfZeroIntegersShouldReturnZero() {
    assertThat("a").as("test context").isEqualTo("a");
  }


}