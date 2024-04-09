package Spotify_task;

import io.restassured.response.Response;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Player {
    String token = "BQCHjnSMrFkn2LJysQUmQryfrwICfaBpd_tGe2Uas0Pc8QemgyZexD35RbrGV_KtPKaXorjCxNzQyBSKJURIrPad_ovBoQQYd8GgujhoO8wbaPJ_BHwokVYENrIiNl-qhN6sFjxea-A_6ZluGJWSHruBenXnSZ42RNgj4txWrUwKl3EZCHkjrrXdJIOsS7ceSbeCXsbQGJPog0jjvwGizyT9neGNtArgRRN9F8mUf6U0Kakt5wdKDbNj1BkACcK6R8fwWuxArxgnWwsMQc074FQcLxBlD-bvvSq9PINrKVQceI0HxKNGk2e73AjYgNKACT4yNbAAz6r9";

    @Test
    public void getplaybackstate(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when().get("https://api.spotify.com/v1/me/player");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void transferplayback(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .header("Content-Type","application/json")
                .when().get("https://api.spotify.com/v1/me/player");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getavailabledevice(){
        Response res = given()
                .header("Authorization","Bearer "+token)

                .when().get("https://api.spotify.com/v1/me/player/devices");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void currentlyplaying(){

        Response res = given()
                .header("Authorization","Bearer "+token)

                .when().get("https://api.spotify.com/v1/me/player/currently-playing");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test // spotify premium required
    public void startplayback(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .header("Content-Type","application/json")
                .when().get("https://api.spotify.com/v1/me/player/play");
        System.out.println("Spotify premium required");
      // res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

     @Test
    public void pause(){
         Response res = given()
                 .header("Authorization","Bearer "+token)
                 .when().get("https://api.spotify.com/v1/me/player/pause");
        // res.then().assertThat().statusCode(200);
        System.out.println("Spotify premium required");
         res.prettyPrint();
     }
     @Test
    public void getrecentlyplayed(){
         Response res = given()
                 .header("Authorization","Bearer "+token)
                 .when().get("https://api.spotify.com/v1/me/player/recently-played");
         res.then().assertThat().statusCode(200);

         res.prettyPrint();
     }
     @Test
    public void getuserqueue(){
        String str ="BQCIg3rknvUTNsImssON0IsCcTd1YdsXml45QSE4Q0qPzQpZg_8pQYB4gEkkzO_w4pbgrlefpi7UPp0cgwMY7A45CS0XxNlAbAC8_SJHh1stuP6UZS12I1qXhuXOU_20uqhpC63CoiHAFGSynBosG6QJMBIj7BUX3HZdhfdlzjvOituhu331j_tAckc061XdBsU9cXlLPwo7ovNu04riOaIQSs7tZwO-slCfKgLxG95-CLscyvQ1KLNhcpajXxXQ2G448Ns41QnLq5JvHgTb-sZBbj0gEeBpBKNc9Tykld3B0fRGMAinqyqfD0DBde4GW6p0vdaWvRxY";
         Response res = given()
                 .header("Authorization","Bearer "+str)
                 .when().get("https://api.spotify.com/v1/me/player/");
         res.then().assertThat().statusCode(200);

         res.prettyPrint();
    }



}
