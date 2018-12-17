package de.allmaennitta.profileservice.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import de.allmaennitta.profileservice.Application;
import org.hamcrest.core.StringContains;
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
@SpringBootTest(classes={Application.class}, webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
//@ContextConfiguration(classes={ModelConfiguration.class})
public class ProfileControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testGetVersion() throws Exception {
    this.mockMvc.perform(get("/version")
        .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().is2xxSuccessful())
        .andExpect(jsonPath("version").exists())
        .andExpect(jsonPath("version").isString())
        .andExpect(jsonPath("version").value("0.9-SNAPSHOT"));
  }

  @Test
  public void testGetDomainId() throws Exception {
    this.mockMvc.perform(get("/domains/backend")
        .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().is2xxSuccessful())
        .andDo(print())
        .andExpect(jsonPath("$", hasSize(3)))
        .andExpect(jsonPath("$[0].name").isString())
        .andExpect(jsonPath("$[0].name").value("Languages"))
        .andExpect(jsonPath("$[0].skills[0].name").value("PHP"));
  }

  @Test
  public void testGetWrongDomainId() throws Exception {
    String wrongId = "backends";
    this.mockMvc.perform(get("/domains/"+wrongId)
        .accept(MediaType.parseMediaType("application/json")))
        .andExpect(status().is4xxClientError())
        .andDo(print())
        .andExpect(jsonPath("code")
            .value(StringContains.containsString(
                String.format("no domain called '%s'",wrongId)
            )));
  }
}
