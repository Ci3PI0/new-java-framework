import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiTests {
	@Test
	void simpleTest() {
		/// AAA Pattern Arrange(Подготовка) -> Act (Исполнение) -> Assert (Сравнение)
		String body = """
			  {
			    "id": 0,
			    "username": "string",
			    "firstName": "string",
			    "lastName": "string",
			    "email": "string",
			    "password": "string",
			    "phone": "string",
			    "userStatus": 0
			  }
			  """;
		Response response = given()
			  .header("accept", "application/json")
			  .header("Content-Type", "application/json")
			  .baseUri("https://petstore.swagger.io/v2/")
			  .when()
			  .body(body)
			  .post("user")
			  .andReturn();

		Assertions.assertEquals(200, response.statusCode());


	}
}
