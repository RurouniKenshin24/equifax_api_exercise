package exercises;

import org.junit.jupiter.api.*;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class Exercise {
    private static int ID = 10;

    @BeforeAll
    public static void setUp(){
        baseURI = ConfigurationReader.getProperty("baseURL");
        basePath = "/api/v1";
    }

    @AfterAll
    public static void tearDown(){
        reset();
    }

    @DisplayName("1.Testing GET/endpoint")
    @Test
    public void testGETEndpoint(){

         int salary =
                    given()
                        .pathParam("id", ID).
                    when()
                        .get("/employee/{id}").
                    then()
                        .statusCode(200)
                        .body("data.id", equalTo(ID))
                        .body("data.employee_name", is("Sonya Frost"))
                        .body("status",is("Successful"))
                        .extract()
                        .jsonPath().getInt("data.employee_salary");

         assertThat(103600,equalTo(salary));
    }

    @DisplayName("2.Testing DELETE/endpoint")
    @Test
    public void testDELETEEndpoint(){
        ID = 800;

        given()
            .pathParam("id",ID).
        when()
            .delete("/delete/{id}").
        then()
            .statusCode(200)
            .body("message",is("successfully! deleted Records"));

        given()
                .pathParam("id", ID).
        when()
                .get("/employee/{id}").
        then()
                .statusCode(404);
    }
}
