import model.Specification;
import model.UserPostman;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class ApiPostmanTests {
    private static UserPostman user;

    @Test
    @DisplayName("Тестирование запроса Get c проверкой status code = 200 и key/value")
    public void checkGetRequest() {
        Specification.requestSpec()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then().log().all()
                .statusCode(200)
                .and().body("args.foo1", equalTo("bar1"), "args.foo2", equalTo("bar2"));
    }

    @Test
    @DisplayName("Тестирование тестового запроса Post с проверкой status code = 200 и key/value по полям name, job")
    public void checkPostRequest() {
        user = new UserPostman("king", "lion");
        Specification.requestSpec()
                .body(user)
                .post("/post")
                .then().log().body()
                .statusCode(200)
                .and().body("json.name", equalTo(user.getName()), "json.job", equalTo(user.getJob()));
    }

    @Test
    @DisplayName("Тестирование тестового запроса Put c обновлением данных user по полю job")
    public void checkPutRequest() {
        user = new UserPostman("king", "bear");
        Specification.requestSpec()
                .body(user)
                .when()
                .put("/put")
                .then().log().all()
                .statusCode(200)
                .and().body("json.name", equalTo(user.getName()), "json.job", equalTo(user.getJob()));
    }

    @Test
    @DisplayName("Тестирование тестового запроса Patch c обновлением данных user по полю name")
    public void checkPatchRequest() {
        user = new UserPostman("prince", "bear");
        Specification.requestSpec()
                .body(user)
                .when()
                .patch("/patch")
                .then().log().all()
                .statusCode(200)
                .and().body("json.name", equalTo(user.getName()), "json.job", equalTo(user.getJob()));
    }

    @Test
    @DisplayName("Тестирование запроса Delete c удалением пользователя")
    public void checkDeleteRequest() {
        user = new UserPostman("prince", "bear");
        Specification.requestSpec()
                .body(user)
                .when()
                .patch("/delete")
                .then().log().all()
                .statusCode(404);
    }
}

