package br.com.xbrain.desafio.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VendaControllerITest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    public void criarVendaWithCorrectBody(){
        given()
                .contentType(ContentType.JSON)
                .body(correctBody())
        .when()
                .post("/venda")
        .then()
                .statusCode(200);
    }

    @Test
    public void criarVendaWithWrongBody(){
        given()
                .contentType(ContentType.JSON)
                .body(emptyIdVendedor())
        .when()
                .post("/venda")
        .then()
                .statusCode(400);

        given()
                .contentType(ContentType.JSON)
                .body(emptyNomeVendedor())
        .when()
                .post("/venda")
        .then()
                .statusCode(400);

        given()
                .contentType(ContentType.JSON)
                .body(nullValor())
        .when()
                .post("/venda")
        .then()
                .statusCode(400);

        given()
                .contentType(ContentType.JSON)
                .body(stringValor())
        .when()
                .post("/venda")
        .then()
                .statusCode(400);

        given()
                .contentType(ContentType.JSON)
                .body(nullDataVenda())
        .when()
                .post("/venda")
        .then()
                .statusCode(400);
    }

    public String correctBody(){
        return """
                {
                    "id_vendedor": "id_vendedor_fake",
                    "nome_vendedor": "nome_vendedor_fake",
                    "valor": 30.25,
                    "data_venda": "2023-05-11"
                }
                """;
    }

    public String emptyIdVendedor(){
        return """
                {
                    "id_vendedor": "",
                    "nome_vendedor": "nome_vendedor_fake",
                    "valor": 30.25,
                    "data_venda": "2023-05-11"
                }
                """;
    }

    public String emptyNomeVendedor(){
        return """
                {
                    "id_vendedor": "id_vendedor",
                    "nome_vendedor": "",
                    "valor": 30.25,
                    "data_venda": "2023-05-11"
                }
                """;
    }

    public String nullValor(){
        return """
                {
                    "id_vendedor": "id_vendedor",
                    "nome_vendedor": "nome_vendedor_fake",
                    "valor": null,
                    "data_venda": "2023-05-11"
                }
                """;
    }

    public String stringValor(){
        return """
                {
                    "id_vendedor": "id_vendedor",
                    "nome_vendedor": "nome_vendedor_fake",
                    "valor": "trinta",
                    "data_venda": "2023-05-11"
                }
                """;
    }

    public String nullDataVenda(){
        return """
                {
                    "id_vendedor": "id_vendedor",
                    "nome_vendedor": "nome_vendedor_fake",
                    "valor": 30.25,
                    "data_venda": null
                }
                """;
    }
}
