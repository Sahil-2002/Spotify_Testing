package Spotify_task;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Shows {
    String token = "BQDbzzZTxyHkf6YCYcZoF3Qcd3qwoqdrbqQILorfQLHx1QWlJ3Zw4jJwCOPZ8O5EkOkHTIGwTZV1YMn33zLdW43MbuJ_U32zdtYKjVrOk7DLappoHo1WqnWyy6nSrd4NZtQfQrNNoe0OiwTF6gb55q_4w4wcSAsC3W1NIVXfwpRxfbJc9eWYCxeSpiexvscU0130XGFCK0N4YBETFC90aciJ87fzgcj_I4jFfCWWsNQYikzvkHtiuRnkYtb-wfJpyZeb0AeL35TDJQE81Y-pjyOv9fk38VwCGSf5Qh4mPIC3bCOPJVJlX17rhALDZTo41IZ7j0C7_SC_";

    @Test
    public void getshows(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/shows/0jCWG5oU6BvRtlLwusgLv5");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
    @Test
    public void getseveralshows(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/shows/?ids=1Ev7VeqtZZiedzzS6QieDb,0jCWG5oU6BvRtlLwusgLv5");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getshowepisode(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/shows/1Ev7VeqtZZiedzzS6QieDb/episodes");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getusersavedshows(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/shows");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void saveshow(){
        Response res = given()
                .header("Authorization","Bearer "+token)

                .when()
                .put("https://api.spotify.com/v1/me/shows?ids=1Ev7VeqtZZiedzzS6QieDb");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }
    @Test
    public void removeshow(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .delete("https://api.spotify.com/v1/me/shows?ids=1Ev7VeqtZZiedzzS6QieDb");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void checksavedshow(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/shows/contains?ids=1Ev7VeqtZZiedzzS6QieDb");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

}
