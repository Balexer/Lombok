package org.techmeskills.aqa5.auf.apiLombokTests;

import org.apache.http.HttpStatus;
import org.techmeskills.aqa5.auf.baseEntity.BaseApiTest;
import org.techmeskills.aqa5.auf.models.ProjectLombok;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AlexApiLombokTests extends BaseApiTest {

    @Test
    public void create() {
        String endpoint = "/api/users";

        ProjectLombok project = ProjectLombok.builder()
                .name("morpheus")
                .job("leader")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("job", project.getJob());

        given()
                .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .body("name", is("morpheus"))
                .body("job", is("leader"))
                .statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    public void registerSuccessfull() {

        String endpoint = "/api/register?/api/register=";

        ProjectLombok project = ProjectLombok.builder()
                .email("eve.holt@reqres.in")
                .password("pistol")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email", project.getEmail());
        jsonAsMap.put("password", project.getPassword());

        given()
                .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then()
                .log()
                .body()
                .statusCode(HttpStatus.SC_OK)
                .body("id", is(4))
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));

    }

    @Test
    public void registerUnSuccessfull() {

        String endpoint = "/api/register?/api/register=";

        ProjectLombok project = ProjectLombok.builder()
                .email("sydney@fife")
                .password("")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email", project.getEmail());
        jsonAsMap.put("password", project.getPassword());

        given()
                .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then()
                .log()
                .body()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("error", equalTo("Missing password"));
    }

    @Test
    public void loginSuccessfull() {

        String endpoint = "/api/login?/api/login";

        ProjectLombok project = ProjectLombok.builder()
                .email("eve.holt@reqres.in")
                .password("cityslicka")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email", project.getEmail());
        jsonAsMap.put("password", project.getPassword());

        given()
                .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then()
                .log()
                .body()
                .statusCode(HttpStatus.SC_OK)
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));

    }

    @Test
    public void loginUnSuccessfull() {

        String endpoint = "/api/login?/api/login";

        ProjectLombok project = ProjectLombok.builder()
                .email("peter@klaven")
                .password("")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email", project.getEmail());
        jsonAsMap.put("password", project.getPassword());

        given()
                .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then()
                .log()
                .body()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("error", equalTo("Missing password"));
    }

    @Test
    public void updatePUT() {

        String endpoint = "/api/users/2?/api/users/2";

        ProjectLombok project = ProjectLombok.builder()
                .name("morpheus")
                .job("zion resident")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("job", project.getJob());

        given()
                .body(jsonAsMap)
                .when()
                .put(endpoint)
                .then()
                .log()
                .body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo(project.getName()))
                .body("job", equalTo(project.getJob()));

    }

    @Test
    public void updatePATCH() {

        String endpoint = "/api/users/2?/api/users/2";

        ProjectLombok project = ProjectLombok.builder()
                .name("morpheus")
                .job("zion resident")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("job", project.getJob());

        given()
                .body(jsonAsMap)
                .when()
                .patch(endpoint)
                .then()
                .log()
                .body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo(project.getName()))
                .body("job", equalTo(project.getJob()));
    }

    @Test
    public void delete() {

        String endpoint = "/api/users/2?/api/users/2";

        ProjectLombok project = ProjectLombok.builder()
                .name("morpheus")
                .job("zion resident")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("job", project.getJob());

        given()
                .body(jsonAsMap)
                .when()
                .delete(endpoint)
                .then()
                .log()
                .body()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
