package model;

import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;

public class RestClient {
  private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

  public RequestSpecification getBaseSpec() {
    return given()
        .baseUri(BASE_URL)
        .header("Content-type", "application/json");
  }
}
