package qaCartTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CoursesTest {
    @Test
    public void shouldBeAbleToGetCoursesDetails (){
        given().baseUri("https://todo.qacart.com/")
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY4ODlmZmQyMmE0ZmRmMDAxNDk1MmRhYiIsImZpcnN0TmFtZSI6IlNhbWFyIiwibGFzdE5hbWUiOiJHaGFyZWIiLCJpYXQiOjE3NTM5NDU3MTl9.fc3y-fXvNaIv5QIccfPmHntdFvhi-2Sg-eDIqHP_dgw," +
                        "    userID: 6889ffd22a4fdf0014952dab")
                .log().all()
                .when().post("/api/v1/courses/6319b5655ce1f40d1b73738")

                .then().log().all();


    }
}
