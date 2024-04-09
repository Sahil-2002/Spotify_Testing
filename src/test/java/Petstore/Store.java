package Petstore;

import io.restassured.response.Response;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Store {

    @Test
    public void petinventoriesbystatus(){
        Response res = given()
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void placeanorderforpet(){
        Response res = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{ \"id\": 1,\n" +
                        "  \"petId\": 1,\n" +
                        "  \"quantity\": 0,\n" +
                        "  \"shipDate\": \"2024-04-08T13:10:01.098+0000\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true }")
                .when()
                .post("https://petstore.swagger.io/v2/store/order");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
    @Test
    public void findpurchasebyid(){
        Response res = given()
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/2");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void deleteorderbyid(){
        Response res = given()
                .header("accept","application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/store/order/2");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();


    }

}
