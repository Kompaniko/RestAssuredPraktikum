package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


//проверка регистрации и авторизации с помощью API
public class PraktikumAssured {

    @Before
    public void setUrl() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru/";
    }

    @Test
    public void registrationAndAutentification() {
        // создание рандомного email
        Random random = new Random();
        String emailAuthetifacation = "random" + random.nextInt(1000000) + "@yandex.ru";

        // составление json
        String json = "{\"email\": \"" + emailAuthetifacation + "\", \"password\": \"abc\" }";

        // создание Post запроса на регистрацию
        given().
                header("Content-type", "application/json")
                .body(json)
                .post("/api/signup")
                // проверка статуса
                .then().statusCode(201);
    }
}