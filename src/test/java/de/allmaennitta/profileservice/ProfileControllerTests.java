package de.allmaennitta.profileservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ProfileControllerTests {

  @Autowired
  private ProfileController profileController;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void findRoot() throws Exception {
    this.mockMvc.perform(get("/")
        .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().is3xxRedirection());
  }

  @Test
  public void findallLearners() throws Exception {
    this.mockMvc.perform(get("/learner/all")
        .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(jsonPath("$.learners[0].id").value(1))
        .andExpect(jsonPath("$.learners[0].name").value("Hugo"));
  }


  @Test
  public void multiplicationOfZeroIntegersShouldReturnZero() {
    assertThat("a").as("test context").isEqualTo("a");
  }
}