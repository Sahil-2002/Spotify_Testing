package Spotify_task;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Artist {

    String token = "BQAHjiXWZtfYxKiTotVUeWRK0a2CY1IPqVsM8aV9GEFA6S5iS_p54G84TIw_zPhNtvb8Ky66IYpxj7vsc3uRoKbVvJsrgVZIWibPViqQNA7MBywMyQBU8qjf2vVXx-LTasbo0IuESe61nWEmOqXLRFGvBYprA9KRNFTRVEZvPaS9IADtHd8kVj7nXPAysttfVDtuDPOrWbLpTk74P9QzhPjoqpNCBXtkALCGv4QxaW72s3gjIFmVzy59beSAOasRmDFIwVoUga9zNz3PRRlkYaUpVpI6rCj8eGxMnT7ikeCWtfoW9XRK39eGgzWJ-lxca3y9BEHePuLc";

    @Test
    public void getartist(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/artists/6jJ0s89eD6GaHleKKya26X");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getseveralartist(){

            Response res = given()
                    .header("Authorization","Bearer "+token)
                    .when()
                    .get("https://api.spotify.com/v1/artists?ids=6jJ0s89eD6GaHleKKya26X,7dGJo4pcD2V6oG8kP0tJRR");
            res.then().assertThat().statusCode(200);
            res.prettyPrint();
    }
@Test
    public void getartistalbum(){
    Response res = given()
            .header("Authorization","Bearer "+token)
            .when()
            .get("https://api.spotify.com/v1/artists/6jJ0s89eD6GaHleKKya26X/albums");
    res.then().assertThat().statusCode(200);
    res.prettyPrint();
}

@Test
    public void getartisttoptrack(){
    Response res = given()
            .header("Authorization","Bearer "+token)
            .when()
            .get("https://api.spotify.com/v1/artists/6jJ0s89eD6GaHleKKya26X/top-tracks");
    res.then().assertThat().statusCode(200);
    res.prettyPrint();
}

@Test
    public void getrealtedartist(){
    Response res = given()
            .header("Authorization","Bearer "+token)
            .when()
            .get("https://api.spotify.com/v1/artists/6jJ0s89eD6GaHleKKya26X/related-artists");
    res.then().assertThat().statusCode(200);
    res.prettyPrint();

}

}
