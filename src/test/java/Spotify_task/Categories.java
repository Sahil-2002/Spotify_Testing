package Spotify_task;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Categories {
    String token = "BQDq31vCGDmmg9rrl4x5hPD_BWaSmXzgQpCBASyzTkgV1fekdm9mFuTvPNIYEgOfxLu3PR7kLFI-g3FrUHKhBP3beTUkmqCQAoBwJR-KMzEGvJursTgL_WgrEjPumYdVIPTy6YNIRu1RLr_ubtIYe_DCkBxyFFSxOz6_BghJ3nTe-paX4RrKLDOatG9GbQB1XH8IZ0n1eXrY78BfBfFK_TSF5r4WrpmSHYkxZIXZ9XY6sjNY3GbB_xmTW_S2n8_FgnIAUgjeS6wMhNgA_K2wCMva0MiFjmcWc_14PZ9xNh6KBa-qkBfQqSCcZy-vfy3EkzoCrtc6p2rp";

    @Test
    public void getcategories(){

        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/browse/categories");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void singlebrowsehistory(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/browse/categories/0JQ5DAt0tbjZptfcdMSKl3");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

}
