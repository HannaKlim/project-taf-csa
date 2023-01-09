package by.itacademy.hanna_klimasheuskaya.api;

import by.itacademy.hanna_klimasheuskaya.domain.User;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ApiTest {
    @Test
    void testGetUserInfo() {
        RestAssured.baseURI = User.baseURI;
        String endPoint = "/auth/getUserInfo";
        given()
                .header("Content-type", "application/json")
                .header("***Token", User.token)
                .when()
                .get(endPoint)
                .then().statusCode(200)
                .body("account.participant.firstName", is("Максим"))
                .body("account.participant.lastName", is("Сотрудник ПОССП"))
                .log().all();
    }

    @Test
    void testFoundCardOfPSU() {
        RestAssured.baseURI = User.baseURI;
        String endPoint = "/registry/find";
        String surname = "ВасильевАвтотестВосемь";

        String requestBody = String.format("{\n" +
                "   \"***\":[\n" +
                "      {\n" +
                "         \"valueType\":\"STRING\",\n" +
                "         \"***\":false,\n" +
                "         \"***\":true,\n" +
                "         \"***\":\"***\",\n" +
                "         \"name\":\"lastName\",\n" +
                "         \"value\":\"%s\"\n" +
                "      },\n" +
                "   ]\n" +
                "}", surname);
        given()
                .header("Content-type", "application/json")
                .header("***Token", User.token)
                .and()
                .body(requestBody)
                .when()
                .post(endPoint)
                .then().statusCode(200)
                .body("data[0].lastName", is(surname))
                .body("meta.total", is(1))
                .log().all();
    }

    @Test
    void testFoundCardOfPSUByIncorrectData() {
        RestAssured.baseURI = User.baseURI;
        String endPoint = "/registry/find";
        String surname = "Климашевская"; //пользователя нет в системе

        String requestBody = String.format("{\n" +
                "   \"***\":[\n" +
                "      {\n" +
                "         \"valueType\":\"STRING\",\n" +
                "         \"***\":false,\n" +
                "         \"***\":true,\n" +
                "         \"***\":\"***\",\n" +
                "         \"name\":\"lastName\",\n" +
                "         \"value\":\"%s\"\n" +
                "      },\n" +
                "   ]\n" +
                "}", surname);
        given()
                .header("Content-type", "application/json")
                .header("***Token", User.token)
                .and()
                .body(requestBody)
                .when()
                .post(endPoint)
                .then().statusCode(200)
                .body("meta.total", is(0))
                .log().all();
    }

    @Test
    void testDeleteCardOfPSU() {
        RestAssured.baseURI = User.baseURI;
        String id = "1552";
        String endPoint = "/registry/" + id;
        given()
                .header("Content-type", "application/json")
                .header("***Token", User.token)
                .and()
                .when()
                .delete(endPoint)
                .then().statusCode(200)
                .log().all()
                .extract().response();
    }

    @Test
    void testDeleteCardOfPSUWithInvalidData() {
        RestAssured.baseURI = User.baseURI;
        String id = "x1536w";
        String endPoint = "/registry/" + id;
        given()
                .header("Content-type", "application/json")
                .header("***Token", User.token)
                .and()
                .when()
                .delete(endPoint)
                .then().statusCode(400)
                .log().all()
                .extract().response();
    }
}

