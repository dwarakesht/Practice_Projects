package org.example;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        RestAssured.baseURI = "https://reqres.in";

        //Create a record using POST
        String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(Payload.jsonBody())
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201)
                .body("name", equalTo("morpheus")).extract().response().asString();
        //Parse JSON using JsonPath class
        JsonPath js = new JsonPath(response);
        Assert.assertEquals(js.get("name"), "morpheus");

        //Update a record using PUT
    }
}
