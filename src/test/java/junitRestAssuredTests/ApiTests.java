package junitRestAssuredTests;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ApiTests {


    @BeforeEach
    public void setup() {
        System.out.println("setting up before each test");
    }

    @AfterEach
    public void teardown() {
        System.out.println("Tearing down after each test");
    }

    @Test
    public void apiTests() {
        given().baseUri("https://6885cfeff52d34140f6a9e3b.mockapi.io/api/v1")
                .when().get("users")
                .then().log().all()


                //Assert status code
                .assertThat().statusCode(200)


                //Assert body
                .assertThat()
                .body("[0].name", Matchers.equalTo("Patti Hegmann"))
                .body("country", hasItem("Virgin Islands, U.S."))
                .body("name", hasItems("Rita Ritchie", "Stanley Runolfsdottir"))
                .body("name", not(hasItems("samar", "fayrouz")))
                .body("name", hasSize(25))
                .body("createdAt", everyItem(startsWith("2025")))
                .body("[1]", hasKey("name"))
                .body("[3]", hasValue("Algeria"))
                .body("[22]", hasEntry("country", "Gabon"));


    }

    //print countries from log
    @Test
    void printCountriesFromLog() {
        List<String> countries =
                given().baseUri("https://6885cfeff52d34140f6a9e3b.mockapi.io/api/v1")
                        .when().get("users")
                        .then()
                        .extract()
                        .path("country");
        countries.forEach(System.out::println);

    }
            //printLogIfError

        @Test
        void printLogIfError () {
            given().baseUri("https://6885cfeff52d34140f6a9e.mockapi.io/api/v1")
                    .when().get("users")
                    .then().log().ifError();
        }


        //printLogIfValidationFails
        @Test
    void  printLogIfValidationFails(){
            given().baseUri("https://6885cfeff52d34140f6a9e3b.mockapi.io/api/v1")
                    .when().get("users")
                    .then().log().ifValidationFails()
                    .body("[0].name", Matchers.equalTo("Patti Hegmann"));



        }
    }













