package Spotify_task;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Playlist {

    String token1 = "BQAPCrdgkNeb7uq1-aG1Q-ba5-LQw-vdo_FY-Q08hJvLM1EtV_EtZMrXYVt0zYWmEYPTovanSuNR6soC84rmuliIHNJRw-RjtNbOSYcQ25thGGUdM6B23mYonthq57tK4d2LDhR76E60ZgVPnNBw0zy7eDHEGC4c_ewZRDQ5XOdoDOXP68p_7rWZxkG8hydBNrjog5G1afjm0DuwwLQaydLnkCY8TFDQCQXNB1h_vnLJls4NEcS_DIJtdf6FMsYd31Z4Hf8zwpYa2l29NhBl7QjpHBksBGr1jXk-mV9qXqLtCsfeIE9fO68O4Xnhw0XANJKfb498QhMo";
    String token2 = "BQBssZxwIbUrp0U1jaAIZNBnUmptwZg-BLjhwqeof9DTs7l79ZtxLrHGyK9RPXJfdclBHSdbH4ncXihoP9YS5bydFb9q8JiqO5v9iieHaOxMV2YKR8IgXqhSff_imtyowZYXMU2mS2MvrYLZcw1NLT-jeGToeryePaRyh7mPhvyw7IeTM3wA9EOkPHLboIzXZmim4DSsSSnqv58RZxYakhPW5cEJHTX96atMtwdU7p_4LOHTaR2SHA7zeb6gZK6-DVWxsnOcMpBcCy4muY8axRegD0KvswrzZIVyfLUXGBpENfX50Yg4gDwSP15XuZZpkbfBfcLhrO52";

    @Test
    public void createplaylist(){

        Response res = given()
                .header("Authorization","Bearer "+token1)
                .header("Content-Type","application/json")
                .when()
                .get("https://api.spotify.com/v1/users/31ofzxzjxtpqnuy3hu5znlr5mucu/playlists");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public  void getplaylist(){
        Response res = given()
                .header("Authorization","Bearer "+token1)

                .when().get("https://api.spotify.com/v1/playlists/6ullfg71kIlvgYMovb3kyf");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getplaylistitem(){
        Response res = given()
                .header("Authorization","Bearer "+token1)

                .when().get("https://api.spotify.com/v1/playlists/6ullfg71kIlvgYMovb3kyf/tracks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void additemtoplaylist(){
        Response res = given()
                .header("Authorization","Bearer "+token1)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"uris\": [\n" +
                        "        \"spotify:track:7lQ8MOhq6IN2w8EYcFNSUk\"\n" +
                        "    ]\n" +
                        "}\n")
                .when().post("https://api.spotify.com/v1/playlists/6ullfg71kIlvgYMovb3kyf/tracks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getcurrentuserplaylist(){
        Response res = given()
                .header("Authorization","Bearer "+token2)
                .when().get("https://api.spotify.com/v1/me/playlists");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

  @Test
    public void getuserplaylist(){
      Response res = given()
              .header("Authorization","Bearer "+token2)
              .when().get("https://api.spotify.com/v1/users/312jqdjelnjctt7ckomd3bzbopla/playlists");
      res.then().assertThat().statusCode(200);
      res.prettyPrint();
    }

    @Test
    public void removeplaylistitem(){
        Response res = given()
                .header("Authorization","Bearer "+token1)
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"tracks\": [\n" +
                        "        {\n" +
                        "         \"uri\":\"spotify:track:7lQ8MOhq6IN2w8EYcFNSUk\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"snapshot_id\":\"AAAAKMnBEfrDOVNQs67DYPx54GXQ6n/r\"\n" +
                        "}")
                .when().delete("https://api.spotify.com/v1/playlists/6ullfg71kIlvgYMovb3kyf/tracks/");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
@Test
    public void changeplaylistdetails(){

    Response res = given()
            .header("Authorization","Bearer "+token1)
            .header("Content-Type","application/json")

            .when().get("https://api.spotify.com/v1/playlists/6ullfg71kIlvgYMovb3kyf/tracks/");
    res.then().assertThat().statusCode(200);
    res.prettyPrint();

}
@Test
    public void getcoverimage(){
    Response res = given()
            .header("Authorization","Bearer "+token1)

            .when().get("https://api.spotify.com/v1/playlists/6ullfg71kIlvgYMovb3kyf/images");
    res.then().assertThat().statusCode(200);
    res.prettyPrint();
}

    @Test
    public void updatePlaylistItem() {
        Response res = given()
                .header("Authorization", "Bearer " + token1)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"range_start\": 0,\n" +
                        "    \"insert_before\": 2,\n" +
                        "    \"range_length\": 1,\n" +
                        "    \"uris\": [\"spotify:track:6I3mqTwhRpn34SLVafSH7G\"]\n" +
                        "}\n")
                .when()
                .put("https://api.spotify.com/v1/playlists/6ullfg71kIlvgYMovb3kyf/tracks");

        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getfeaturedplaylist(){

            Response res = given()
                    .header("Authorization","Bearer "+token1)

                    .when().get("https://api.spotify.com/v1/browse/featured-playlists");
            res.then().assertThat().statusCode(200);
            res.prettyPrint();
    }

    @Test
    public void getcategoryplaylist(){
        Response res = given()
                .header("Authorization","Bearer "+token1)

                .when().get("https://api.spotify.com/v1/browse/categories/0JQ5DAt0tbjZptfcdMSKl3/playlists");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }






}
