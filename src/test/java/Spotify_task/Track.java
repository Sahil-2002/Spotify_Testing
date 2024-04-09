package Spotify_task;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Track {

    String token = "BQBlJ60nCRUDeW9--MPfE9QCrxV09CZEDK_IyLUBgJrOxDAq_XcYqh8st7MUnt1uBv3BSLk4SH8AOD24AuCTeSWtEi83P8CqZl-cH2FONV-Og1ZRptLSgKaA2PXojyERofS-jiJajhb8hSo1Hp0wvJPTNvOsb1fr-SqGjsZXOKaup6p1CuEpGjgpMMg_rBySAJVGQfRE9BD-AIZlJP3yKlYwO628VGL0qetwEn6z3DmZOAuv09A06vTv4TeG7pf5alcTz8w1B6fcqU8vuQcwyT7-PYB3PZ4mtrr21TzHB256D7z7wlKNCgVN2kIgBjRcGZ90J3sYR9NK";

    @Test
    public void gettrack(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when().get("https://api.spotify.com/v1/tracks/367wyLNqQMr5e8S2E6Zvpp");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
    @Test
    public void getseveraltracks(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when().get("https://api.spotify.com/v1/tracks?ids=367wyLNqQMr5e8S2E6Zvpp, 22vgEDb5hykfaTwLuskFGD");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getsavedtracks(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when().get("https://api.spotify.com/v1/me/tracks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
    @Test
    public void savetrackforuser(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"ids\": [\n" +
                        "        \"367wyLNqQMr5e8S2E6Zvpp\", \"1u8c2t2Cy7UBoG4ArRcF5g\"\n" +
                        "    ]\n" +
                        "}")
                .when().put("https://api.spotify.com/v1/me/tracks?ids=367wyLNqQMr5e8S2E6Zvpp&ids=1u8c2t2Cy7UBoG4ArRcF5g");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void removetrack(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .header("Content-Type","application/json")
                .when().delete("https://api.spotify.com/v1/me/tracks?ids=367wyLNqQMr5e8S2E6Zvpp");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
    @Test
    public void checkusersavedtrack(){
        Response res = given()
                .header("Authorization","Bearer "+token)

                .when().get("https://api.spotify.com/v1/me/tracks/contains?ids=1IIV8jglA0klVZy17q665k");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
    @Test
    public void gettrackaudio(){
        Response res = given()
                .header("Authorization","Bearer "+token)

                .when().get("https://api.spotify.com/v1/audio-features?ids=1htQDV8JxSuXG2QsNj5ttr,4jbmgIyjGoXjY01XxatOx6");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
    @Test
    public void trackaudio(){
        Response res = given()
                .header("Authorization","Bearer "+token)

                .when().get("https://api.spotify.com/v1/audio-features/4jbmgIyjGoXjY01XxatOx6");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
    @Test
    public void trackaudioanalysis(){
        Response res = given()
                .header("Authorization","Bearer "+token)

                .when().get("https://api.spotify.com/v1/audio-analysis/4jbmgIyjGoXjY01XxatOx6");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }
    @Test
    public void getrecommendation(){
        Response res = given()
                .header("Authorization","Bearer "+token)

                .when().get("https://api.spotify.com/v1/recommendations?seed_artists=6jJ0s89eD6GaHleKKya26X&seed_genres=classical&country%26seed_tracks=1htQDV8JxSuXG2QsNj5ttr");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

}
