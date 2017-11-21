package de.allmaennitta.mindware.learner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class LearnerControllerTests {

  @Autowired
  private LearnerController learnerController;

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