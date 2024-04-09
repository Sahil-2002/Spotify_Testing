package Petstore;

import io.restassured.response.Response;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Pet {
    @Test
    public void addnewpet(){
        Response res = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 2,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .post("https://petstore.swagger.io/v2/pet");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void updateanpet(){
        Response res = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"Cat\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/pet");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void findbystatus(){
        Response res = given()
                .header("accept","application/json")
                .when().get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
    @Test
    public void findpetbyid(){
        Response res = given()
                .header("accept","application/json")
                .when().get("https://petstore.swagger.io/v2/pet/2");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
    @Test
    public void updatepetbyformdata(){
        Response res = given()
                .header("accept","application/json")
                .header("Content-Type","application/x-www-form-urlencoded")
                .body("name=Hello")
                .when()
                .post("https://petstore.swagger.io/v2/pet/1");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void deletepet(){
        Response res = given()
                .header("accept","application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/pet/2");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }


}


