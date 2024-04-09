package Spotify_task;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



public class User {
    String tokenUser = "BQDJLPhvQJ3Ss2IZjbYVe4kjl4tNAsoKJxalm2nNVB4U---ygq7ymTA80Z9TDD7QkJfv4qb2OZIKxWchmfdXX-0Nx89LBiNBB3aIhrqrPovbeEk3gUrrdIKDGh12_d1Pn75f6-wAzjGBv9rD4FOEDrHKwTi_WYE3Z8U11DgMbIYVEDmMWzavHBsbUOYjbwPP84Rr4aX0Mp5t6hQ5mEprHlvRlVwkRQZUQ8wbcLagUu-8wynTRWrfRnFTP1TQPaVGmzCWDpd89uHM3A-SrOAm4zXCE7BBunR1t2PIS6N79LFMHNdWrpQuB96tQnuwfcJuC7xWbzMRPcJV";
    String tokenplaylist = "BQAwDFSVKGvsjXZipcEZQE5JtMBlkiW3gJi0yBFRIcVx8yxUNSXeM9OUhq_NwVM8Y3zeychqI36LUWuzj8ondu-zxVp46DCZD3J-hlPl8sXePeABdNb2hy7kshLHAw06EKDLxf-bDTm5MuI71mE6Asxg7h2mBumJK2N1lFWcwx8wt_25Bvvtyd8KE2W8jud7M6iAQZDjGTSlkNS_RN8BVOavv0wsIpHcaZTMcUNPKEvGOYYlEYIhehNF-pkL_Vn3G-D6a2HaR3ZBPmJzjdIVIbcrO4S0Afb_ba3Y3UreTWNgfSBdCqBoc_VO8pLvgyr09JEauZz6K-0y";
    String Spotify_playlist = "BQCgCyR7ejL365imKsFeRdBhxY0oD52u6kkWyvkvHmua05kyd5diynLrc07b4eASr6VgYiqYUxTrBBFD0MBp-WQqy19E0e4ezYcda9vwV3gtNWS3ORSzUSgItqeawmUJ2oyxTUjVuM-ypDRX1XRMRmZNxpZbJSRXZkYncwgz5_Y5FIAeEDs9FEtsrGOVt4W_U3_geDhqlpKgyt_Z02byRT7FIEnZ2nmVgyO5fmemykNRwfH9iZXGeK_b1SnKlkPayESluo2fgpJbsvzgh-21TUs2cjpEfa8LVBgY-_MRh62MPtv0-6MJYvsbW5MBvTJ8-xB5v7Y86-5r";
    @Test
    public void getuser() {
        Response res = given()
                .header("Authorization", "Bearer " + tokenUser)
                .when()
                .get("https://api.spotify.com/v1/me");

        // Validating the status code
        res.then().assertThat().statusCode(200);

        // Printing the response
        res.prettyPrint();
    }

    @Test
    public void getuserprofile() {
        // enviroment variable
        String user_id = "31ofzxzjxtpqnuy3hu5znlr5mucu";
        Response res = given()
                .header("Authorization", "Bearer " + tokenUser)
                .when()
                .get("https://api.spotify.com/v1/users/" + user_id);
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void putfollowplaylist() {
        Response res = given()
                .header("Authorization", "Bearer " + tokenplaylist)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"public\": false\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/playlists/6ullfg71kIlvgYMovb3kyf/followers");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void unfollowplaylist() {
        Response res = given()
                .header("Authorization", "Bearer " + tokenplaylist)
                .when().
                delete("https://api.spotify.com/v1/playlists/4J8n9H0SgXHCavOIxkLWCA/followers");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void followartist() {

        Response res = given()
                .header("Authorization", "Bearer" +tokenUser)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"ids\":[\n" +
                        "        \"1uNFoZAHBGtllmzznpCI3s\"\n" +
                        "        ]\n" +
                        "    \n" +
                        "    }")
                .when().
                put("https://api.spotify.com/v1/me/following?type=artist&ids=1uNFoZAHBGtllmzznpCI3s");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();


    }

    String str = "BQAqgMOZ4f1WajSDvioRYB11yPQTk6AUhw4EGjXcv7ue34OL8yTTg16x-w5BPOzDKNuQvufglqB8UNdluxfd4KP4AElpnDV5ezShn2QXU3LMVqIpV0d-RuHYETs1V0kMAyaLC-cxLc5aHJdaQckjUcThN65ONDyqNruGp0dw3pKG3cNHU181n1xD3wDP7WJ0e1yPJE3jcauUPGoy8aavg_GKHo5Czt0TPaJDCmZgpLldHJHvBF4RF2YKmbjd2ZaW4tAAJmaMEZYePtmXPYQjHjtRK1WBTEnclm4-Vq_Fiog3MjihYIj7Ot7oUXU17Ooz894hVQKkeIvG";

    @Test
    public void checkuserfollowartist() {
        Response res = given()
                .header("Authorization", "Bearer " + str)
                .when()
                .get("https://api.spotify.com/v1/me/following?type=artist&ids=1uNFoZAHBGtllmzznpCI3s");

        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void checkuserfollowplaylist() {
        //String str = "BQCHTrMrhbqsnkwJNpvY0vNIDKptkgN3bkuWJMUC5FPkIKjAXiHmacoZ4YOQ2Y2XmcKtj2uhnrmWLuxEzZd0BztKSy3S-Q6cwExS6WGJFcGgr3zgzmF5kr22pUzAzWh-m8MwAVwIOsVOTBt_lOHxCNgYIl-XinhsqGeqh-7DtDe4hXAoKsWC0q5WpCyGl-2wZLEvzS8Gj0bqJoEzS7Jt5Dk9Wb1uDy7pvZPf4e-GjRXFPdzRLHNmkPvvCFUDqoWmAxswgK_svZ-ImLCNGPzwltJC0YroXuqIXedeU2xFIb-3NvS5AtdhAs3xFtzSrZw7XGlDyCYKXRVl";
        Response res = given()
                .header("Authorization", "Bearer" +tokenUser)
                .when()
                .get("https://api.spotify.com/v1/playlists/6ullfg71kIlvgYMovb3kyf/followers/contains?ids=31ofzxzjxtpqnuy3hu5znlr5mucu");

        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void unfollowartist() {
        String token = "BQAF0XdiqVm3V5tjSr2QdR5vbXlG1sj9T5GmUq_0ou5pXDSyFgKlK22Ko5_cHFhr3CPBGPF-leUiJAFTdnCA-y1pACQfQkCv-DLMQHuxUevtZEnxxy6wp60fU4bIozwX5Rr23U78G6GdY7Q9AQ3EPVURlAi3f0cPqc3Ibf1tsALb8bqTjsgakGhR1ieYio6Lk3kk22FLL6MBEfTbI4nEIxiEpV7RRVpPe4WR_UXpV8et6hLvbA9EHC4MAM-_NzXoWSPX5Zif7EwLSWn-HD8Pvb4EGy9ZGbvsed7blpH94UTBPdhWV1wcP1MYKHZJ6lNiTnGsidtRl1YE";
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .when()
                .get("https://api.spotify.com/v1/me/following?type=artist&ids=1uNFoZAHBGtllmzznpCI3s");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }

    @Test
    public void getusertopitem() {
        Response res = given()
                .header("Authorization", "Bearer " + tokenUser)

                .when()
                .get("https://api.spotify.com/v1/me/top/artists");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();
    }

    @Test
    public void getfollowedartist() {
        Response res = given()
                .header("Authorization", "Bearer " + tokenUser)

                .when()
                .get("https://api.spotify.com/v1/me/following?type=artist");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }
    //
    @Test
    public void userfollowaplaylist() {
        String str = "BQAF0XdiqVm3V5tjSr2QdR5vbXlG1sj9T5GmUq_0ou5pXDSyFgKlK22Ko5_cHFhr3CPBGPF-leUiJAFTdnCA-y1pACQfQkCv-DLMQHuxUevtZEnxxy6wp60fU4bIozwX5Rr23U78G6GdY7Q9AQ3EPVURlAi3f0cPqc3Ibf1tsALb8bqTjsgakGhR1ieYio6Lk3kk22FLL6MBEfTbI4nEIxiEpV7RRVpPe4WR_UXpV8et6hLvbA9EHC4MAM-_NzXoWSPX5Zif7EwLSWn-HD8Pvb4EGy9ZGbvsed7blpH94UTBPdhWV1wcP1MYKHZJ6lNiTnGsidtRl1YE";
        Response res = given()
                .header("Authorization", "Bearer " + str)

                .when()
                .get("https://api.spotify.com/v1/playlists/6ullfg71kIlvgYMovb3kyf/followers/contains?ids=31ofzxzjxtpqnuy3hu5znlr5mucu ");
        res.then().assertThat().statusCode(200);
        res.prettyPrint();

    }


}