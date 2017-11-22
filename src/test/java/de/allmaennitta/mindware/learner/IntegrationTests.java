package de.allmaennitta.mindware.learner;

import static io.restassured.http.ContentType.JSON;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IntegrationTests {

  @LocalServerPort
  int port;


  @Test
  public void rootTest() {
    RestAssured.port = port;
    String json =
        when().
            get("/").
            then().
            contentType(JSON).
            statusCode(200).
//            body("learners[0].name", is("Hugo")).
    extract().
            response().body().print();

    assertThat(JsonPath.from(json).getString("learners[0].name")).isEqualTo("Hugo");
  }

}