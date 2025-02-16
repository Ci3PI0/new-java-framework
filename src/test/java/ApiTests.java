import controllers.UserController;
import io.restassured.response.Response;
import models.AddUserResponse;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static testdata.TestData.DEFAULT_USER;
import static testdata.TestData.INVALID_USER;

public class ApiTests {
    UserController userController = new UserController();

    //	@Test
//	void simpleTest() {
//		/// AAA Pattern Arrange(Подготовка) -> Act (Исполнение) -> Assert (Сравнение)
//		String body = """
//			  {
//			    "id": 0,
//			    "username": "string",
//			    "firstName": "string",
//			    "lastName": "string",
//			    "email": "string",
//			    "password": "string",
//			    "phone": "string",
//			    "userStatus": 0
//			  }
//			  """;
//		Response response = given()
//			  .header("accept", "application/json")
//			  .header("Content-Type", "application/json")
//			  .baseUri("https://petstore.swagger.io/v2/")
//			  .when()
//			  .body(body)
//			  .post("user")
//			  .andReturn();
//
//		Assertions.assertEquals(200, response.statusCode());
//
//
//	}


    @Test()
    void createDefaultUserController() {

        Response response = userController.createDefaultUser();
        AddUserResponse addUserResponse = response.as(AddUserResponse.class);
        System.out.println(addUserResponse);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(200, addUserResponse.getCode());
        Assertions.assertEquals("unknown", addUserResponse.getType());
        Assertions.assertFalse(addUserResponse.getMessage().isEmpty());

    }

    @Test()
    void createUserController() {

        Response response = userController.createUser(DEFAULT_USER);
        AddUserResponse addUserResponse = response.as(AddUserResponse.class);
        System.out.println(addUserResponse);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(200, addUserResponse.getCode());
        Assertions.assertEquals("unknown", addUserResponse.getType());
        Assertions.assertFalse(addUserResponse.getMessage().isEmpty());

    }

    @Test
    void createUserController2() {
        Response response = userController.createUser(INVALID_USER);
        AddUserResponse addUserResponse = response.as(AddUserResponse.class);
        System.out.println(addUserResponse);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(200, addUserResponse.getCode());
        Assertions.assertEquals("unknown", addUserResponse.getType());
        Assertions.assertEquals(INVALID_USER.getId(), Integer.parseInt(addUserResponse.getMessage()));
    }

    static Stream<User> users() {
        return Stream.of(DEFAULT_USER, INVALID_USER);
    }

    @ParameterizedTest()
    @MethodSource("users")
    void createUserParametrizedController(User user) {

        Response response = userController.createUser(user);
        AddUserResponse addUserResponse = response.as(AddUserResponse.class);
//        System.out.println(addUserResponse);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(200, addUserResponse.getCode());
        Assertions.assertEquals("unknown", addUserResponse.getType());
        Assertions.assertFalse(addUserResponse.getMessage().isEmpty());

    }

    @Test
    void deleteUser() {
        Response response = userController.deleteUserByUsername(DEFAULT_USER.getUsername());
        System.out.println(response.asString());
        Assertions.assertEquals(200, response.statusCode());
    }
}
