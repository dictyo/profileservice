package de.allmaennitta.profileservice.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import de.allmaennitta.profileservice.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@SpringBootTest(
  classes = Application.class,
  webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ContextConfiguration
@AutoConfigureMockMvc
public class SpringIntegrationTest {
  static ResultActions latestResponse = null;

  @Autowired
  MockMvc mockMvc;

}
