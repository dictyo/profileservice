package de.allmaennitta.mindware.learner;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IntegrationTests {

  @LocalServerPort
  int port;

  //  @Autowired
//  private TestRestTemplate restTemplate;
//
//  @Test
//  public void rootTest() {
//    String body = this.restTemplate.getForObject("/", String.class);
//    assertThat(body).isEqualTo("Hello World");
//  }

  @Test
  public void rootTest() {
    RestAssured.port = port;
    Response response =
        when().
            get("/").
            then().
            contentType(JSON).
            statusCode(200).
//            body
//            body("id", equalTo(1)).
    extract().
            response();

    System.out.println(response.body().print());
  }
}