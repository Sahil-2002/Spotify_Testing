package Spotify_task;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Search {

    String token = "BQBVq2WKFLKmYjUS-6_KVf5BDqxRyn0eacdn7giGC9QdsYXzeRIOXuNoZXbO0iM-7fA7MDRxRBK_TuQ9ATGr9NoROsCeRKKDuwIMPrnvynxrEisEHvVbNCAUjZ4yLBmWx2SdZWrv2VXobLFbpEryMF7FuT2bRH7BlpcxVkCamOYGwPx9SdFPprZxLzhpOSTRKkLODA3bo56SvGeXEY6FRl5Jr8N6TI8LovfbnK1tsHSQxv-l48GSj--RVkzNbGOmc5eqRKRb5dAo6y4gnC0tfzLeclynOkcggMnPiakqCYoBirkE1BgKBsER-9Y2v9sRoOIwKJrESfHO";

    @Test
    public void serachitem(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/shows?offset=1&limit=1");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }


}
