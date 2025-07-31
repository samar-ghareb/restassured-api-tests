package qaCartTest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import pojoClass.LoginPojo;

import java.io.File;

import static io.restassured.RestAssured.given;

public class StudentsTests {
    @Test
    public void shouldBeAbleToLoginTotheApplication() {
        LoginPojo body = new LoginPojo();
        body.setEmail("user5@gmail.com");
        body.setPassword("user5@123");



       //to send a body as afile
      // File body = new File("src/test/resources/login.json");


        given().baseUri("https://todo.qacart.com/")
                .log().all()
                .body(body)
                .contentType(ContentType.JSON)
                .when().post("/api/v1/students/login")

                .then().log().all();



    }
}
