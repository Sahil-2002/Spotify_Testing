package Spotify_task;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Episode {

    String token = "BQCid6UmRrXwrnymxnuQu1zsDMdshN-08VVhVZk_nHWlp3RHbmEWXX3H6j1hZ5lVmSX_Hm-oiwFBKqe0aRGg4D1uUMUZ5F3G_YMxIwx2wlXqALKNZI57eI0WUkUZApKTdehw8nA3DgEAZVamyug1sfLLMO7H3Sx2J488UW2Qw1-k3gbXZ4GQyrErho9wLcZFm53FzfGl7a9Nu4yf5p49GTzBQQoBvOJtu6xm-NFjJ1dJ3v6J6A7_34Tj9P1YZcZhH50Bcfs8jNYPz7Zfg2NXCNSlOEEGmB7cKhpLzyGXX8fucXrshlCuUHPjwA7sHdYrYHxJCI3HtdRb";

    @Test
    public void getepisode(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/episodes/2t7J3RvWNvcq9SYg7btdK2");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getseveralepisode(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/episodes?ids=2t7J3RvWNvcq9SYg7btdK2&ids=5TGr9rFeVcIdRyJOgOCsT6");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getusersavedEpisode(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/episodes");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void saveepisode(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"ids\": [\n" +
                        "        \"5TGr9rFeVcIdRyJOgOCsT6\"\n" +
                        "    ]\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/me/episodes?id=5TGr9rFeVcIdRyJOgOCsT6");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void removeepisode(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .header("Content-Type","application/json")
                .when()
                .delete("https://api.spotify.com/v1/me/episodes?ids=5TGr9rFeVcIdRyJOgOCsT6");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void usersavedepisode(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/episodes/contains?ids=5TGr9rFeVcIdRyJOgOCsT6");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }


}
