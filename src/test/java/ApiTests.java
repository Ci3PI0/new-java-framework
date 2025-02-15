import controllers.UserController;
import io.restassured.response.Response;
import models.AddUserResponse;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

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
	User user1 = new User(
		  "username",
		  "firstname",
		  "LastName",
		  "some@gmail.com",
		  "qwe123",
		  "77777777",
		  11231,
		  0);

	@Test()
	void createUserController() {


		User userBuilder = User.builder()
			  .username("BuilderUserName")
			  .firstName("BuildFirstName")
			  .lastName("BuildLastName")
			  .email("build@gmail.com")
			  .phone("12345689")
			  .password("qwe123123")
			  .id(1231231)
			  .userStatus(0)
			  .build();

		Response response = userController.createUser(user1);
		AddUserResponse addUserResponse = response.as(AddUserResponse.class);
		System.out.println(addUserResponse);

		Assertions.assertEquals(200, response.statusCode());
		Assertions.assertEquals(200, addUserResponse.getCode());
		Assertions.assertEquals("unknown", addUserResponse.getType());
		Assertions.assertEquals(user1.getId(), Integer.parseInt(addUserResponse.getMessage()));

	}

	@Test
	void deleteUser() {
		Response response = userController.deleteUserByUsername(user1.getUsername());
		System.out.println(response.asString());
		Assertions.assertEquals(200, response.statusCode());
	}
}
