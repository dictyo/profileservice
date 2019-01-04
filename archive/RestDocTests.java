package de.allmaennitta.profileservice.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import de.allmaennitta.profileservice.Application;
import org.hamcrest.core.StringContains;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class}, webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class RestDocTests {
  @Rule
  public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

  @Autowired
  private WebApplicationContext context;

  private MockMvc mockMvc;

  @Before
  public void setUp() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
        .apply(documentationConfiguration(this.restDocumentation))
//        //automatically register every mockMvcCall
//        .alwaysDo(document("{method-name}",
//            preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))
        .build();
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
