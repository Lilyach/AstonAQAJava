package model;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Specification {
    public static RequestSpecification requestSpec() {
        return given()
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.JSON);
    }
}
