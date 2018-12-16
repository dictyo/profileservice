package de.allmaennitta.profileservice.integration;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

public class StepDefsMainTest extends SpringIntegrationTest {
  private ResultActions latestResponse = null;

  @When("^the client gets ([A-Za-z0-9\\-\\.\\_\\~\\/]+)$")
  public void the_client_issues_GET(String path) throws Throwable {
    latestResponse = this.mockMvc.perform(get(path)
        .accept(MediaType.parseMediaType("application/json")));
  }

  @Then("^the client receives status code of (\\d+)$")
  public void the_client_receives_status_code_of(int statusCode) throws Throwable {
    latestResponse
        .andExpect(status().is(statusCode));
  }

  @And("^the client receives field (.+) with value (.+)$")
  public void the_client_receives_field_of_value(String path, String value) throws Throwable {
    latestResponse
        .andExpect(jsonPath(path).exists())
        .andExpect(jsonPath(path).isString())
        .andExpect(jsonPath(path).value(value));
  }

  @Then("^the client receives (\\d+) categories$")
  public void the_client_receives_categories(int amtOfCategories) throws Throwable {
    latestResponse
        .andExpect(jsonPath("categories",hasSize(amtOfCategories)));
  }
}
