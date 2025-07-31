package qaCartTest;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class InfoTest {

    @Test
    public void shouldBeAbleToGetCourseInfo() {

        HashMap <String, String> infoHeaders = new HashMap<>();
        infoHeaders.put("type", "web");
        infoHeaders.put("language", "java");

                given().baseUri("https://todo.qacart.com/")
                       .headers(infoHeaders)
                        .log().all()


                        .when().get("/api/v1/info/courses")

                   .then().log().all()
                        .assertThat().statusCode(200);
    }


    @Test
    public void shouldBeAbleToGetLecturesInfo(){
        HashMap<String, String> queries = new HashMap<>();
        queries.put("type", "video");
        queries.put("mode", "paid");
        given().baseUri("https://todo.qacart.com/")
                .queryParams(queries)
                .log().all()

                .when().get("/api/v1/info/lectures")

                .then().log().all()
                .assertThat().statusCode(200);



    }


}
