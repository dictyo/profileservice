package de.allmaennitta.profileservice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.when;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;

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