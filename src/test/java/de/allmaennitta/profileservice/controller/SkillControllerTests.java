package de.allmaennitta.profileservice.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
public class SkillControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testGetPostDeleteSkill() throws Exception {
    String name = "n";
    String skill1="{\"name\":\""+name+"\",\"name_plotly\":\"np\",\"domain\":\"d\","
        + "\"category\":\"c\"}";

    this.mockMvc.perform(
        post("/skills")
          .contentType(MediaType.APPLICATION_JSON)
          .content(skill1)
          .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is2xxSuccessful())
        .andDo(print())
        .andExpect(jsonPath("$.name").value("n"))
        .andExpect(jsonPath("$.domain").value("d"));

    this.mockMvc.perform(get("/skills/"+name)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is2xxSuccessful())
        .andDo(print())
        .andExpect(jsonPath("$.name").value("n"))
        .andExpect(jsonPath("$.domain").value("d"));

    this.mockMvc.perform(delete("/skills")
        .contentType(MediaType.APPLICATION_JSON)
        .content(skill1)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is2xxSuccessful());

    this.mockMvc.perform(get("/skills/"+name)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError())
        .andDo(print());
    //TODO: specify
  }
//  @Test
//  public void testGetWrongDomainId() throws Exception {
//    String wrongId = "backends";
//    this.mockMvc.perform(get("/domains/"+wrongId)
//        .accept(MediaType.parseMediaType("application/json")))
//        .andExpect(status().is4xxClientError())
//        .andDo(print())
//        .andExpect(jsonPath("code")
//            .value(StringContains.containsString(
//                String.format("no domain called '%s'",wrongId)
//            )));
//  }
}
