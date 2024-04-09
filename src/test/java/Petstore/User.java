package Petstore;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class User {

    @Test
    public void createuser(){
        Response res = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"username\": \"Sahil\",\n" +
                        "  \"firstName\": \"string\",\n" +
                        "  \"lastName\": \"string\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"string\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/user");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void listofuserarray(){
        Response res = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 2,\n" +
                        "    \"username\": \"Anil\",\n" +
                        "    \"firstName\": \"string\",\n" +
                        "    \"lastName\": \"string\",\n" +
                        "    \"email\": \"string\",\n" +
                        "    \"password\": \"string\",\n" +
                        "    \"phone\": \"string\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }\n" +
                        "]")
                .when()
                .post("https://petstore.swagger.io/v2/user/createWithArray");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void getlogin(){
        Response res = given()
                .header("accept","application/json")
                .queryParam("un","Anil")
                .queryParam("ps","string")
                .when()

                .get("https://petstore.swagger.io/v2/user/login?username=un&password=ps");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void userlogout(){
        Response res = given()
                .header("accept","application/json")
                .when()

                .get("https://petstore.swagger.io/v2/user/logout");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getuserbyname(){
        Response res = given()
                .header("accept","application/json")
                .when()

                .get("https://petstore.swagger.io/v2/user/string");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void updateuser(){
        Response res = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"string\",\n" +
                        "  \"firstName\": \"string\",\n" +
                        "  \"lastName\": \"string\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"string\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/user/sahil");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();


    }
    @Test
    public void deleteuser(){
        Response res = given()
                .header("accept","application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/user/string");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();


    }

}
