package Spotify_task;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Market {
String str = "BQBsZi7iAqNm1uQ6wx8NkLsUsK2vE_ADr_07eriNQkhTvIo1QownlOrBJRYe3-vHRSbW0HIIdB38TldOh2FgEN7WkA0ydOGNP66oLkS2ApHw9qgyJ2t0g33q66ilbH0G1mIVvt_MBfhjsjy7BsgTsau5QUKrveMPvX9D9e91fM-OcFFm9_zNZo9LLe3YEFrIUMte-ws_NgNgDLfinngrXEB0fsv4-Bw76vCjlqkVaj6zYwnFulqYfdP9ZhullhWmxA5kQOksbTCRwHp3hZ7Jov0GNRzCv_t6JSKgkExLGaDOOjSxmqrSJN3PN_0bbtR3F_ImNRpFEX9f";
    @Test
    public void getmarket(){
        Response res = given()
                .header("Authorization","Bearer "+str)
                .when().get("https://api.spotify.com/v1/markets");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
}
