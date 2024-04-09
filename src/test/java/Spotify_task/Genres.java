package Spotify_task;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Genres {
    String token = "BQAWOoOT2cAVc7FyiGKgGf1H21jVu1XsbGF8GC2pc_HhO2eUfo49nJsv5UC8uEHRmsPz5eJaJluUgmfyZNlbjbuEzxSyPyvLGcb2du5_T7C1pyvJWLk2LzYYTp2KSmsJ9caPauIXV3JljDOpAI5jmYlSB8yucf0cj0xGdEr7ddepo90GHDei6shDNvQybIw4xlQ8EyTmZHgbltldpuhiWYm7wbN07veZ0BQUsXwEL_kosheWPAkRGbV2LSqyWnea5TYN0Rq-DBdaoAFpQP-yjNtKie4GJAnozPfGTCGxKYBn96gl-L5l1g";
@Test
    public void getavailablegenreseeds(){
    Response res = given()
            .header("Authorization","Bearer "+token)
            .when()
            .get("https://api.spotify.com/v1/recommendations/available-genre-seeds");


}


}
