package de.allmaennitta.profileservice.integration;

import static io.restassured.path.json.JsonPath.from;
import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import org.springframework.http.HttpStatus;

public class StepDefsMainTest extends SpringIntegrationTest {

  @When("^the client gets /version$")
  public void the_client_issues_GET_version() throws Throwable {
    executeGet("http://localhost:8090/version");
  }

  @Then("^the client receives status code of (\\d+)$")
  public void the_client_receives_status_code_of(int statusCode) throws Throwable {
    HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
    assertThat(currentStatusCode.value())
      .as("status code is incorrect : " + latestResponse.getBody())
      .isEqualTo(statusCode);
  }

  @And("^the client receives field (.+) with value (.+)$")
  public void the_client_receives_field_of_value(String path, String value) throws Throwable {
    assertThat(JsonPath.from(latestResponse.getBody()).getString(path)).isEqualTo(value);
  }
}
