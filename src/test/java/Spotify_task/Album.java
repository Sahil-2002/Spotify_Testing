package Spotify_task;

import io.restassured.response.Response;
import org.codehaus.groovy.control.io.ReaderSource;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Album {

    String token = "BQADy8kdzvJUtoxW_TBYlurfoYRnXNr0EW67Lpbw7FtJfsJbiiBjVc_gGjksusUB6S47aMd1GRd9xCfKPwvWt-qSk9BlAkqgmOs1EN3bCCd0c1_VlhrsIHPlatvMxbxKow5ggW1BoZADZDk-5u2ECDLhe70AVWt6rUyf6lHp00gMmrJ7r07YpU_jRZj-Wosg20LFulmtVgn4gcusQwLBO6-jFdHXSLcE9DUCJBpN3AJF7atY5IO2Oct9Z5w0upcuPJgibNEnV9v_EG7iW5nk_J-Ab_CeCQip2-ujKSEZ5R7lJfosWKEs8erjipd_CjsdNXvqQWQLgg8Q";

    @Test
    public void getalbum(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/albums/47zMF6LrXQ8odi6Xv1unC0");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getseveralalbum(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/albums?ids=3jB9yFDwRe3KhtGnHXJntk,47zMF6LrXQ8odi6Xv1unC0");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
    @Test
    public void getalbumtrack(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/albums/47zMF6LrXQ8odi6Xv1unC0/tracks");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void usersavedalbum(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/albums");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void save_album(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"ids\": [\n" +
                        "        \"47zMF6LrXQ8odi6Xv1unC0\"\n" +
                        "    ]\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/me/albums?ids=47zMF6LrXQ8odi6Xv1unC0");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void removeusersavedalbum(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .header("Content-Type","application/json")
                .when()
                .delete("https://api.spotify.com/v1/me/albums?ids=47zMF6LrXQ8odi6Xv1unC0");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void checkusersavedalbum(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/albums/contains?ids=47zMF6LrXQ8odi6Xv1unC0");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }
    @Test
    public void getnewrealeases(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/browse/new-releases");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

}
