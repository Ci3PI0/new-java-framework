package controllers;

import constants.CommonConstants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.User;
import static io.restassured.RestAssured.given;

public class UserController {
	RequestSpecification requestSpecification;
	private static final String USER_ENDPOINT = "user";

	public UserController(){
		this.requestSpecification = given()
			  .accept(ContentType.JSON)
			  .contentType(ContentType.JSON)
			  .baseUri(CommonConstants.BASE_URL);
	}

	public  Response createUser(User user){
		return given(this.requestSpecification)
			  .body(user)
			  .when().post(USER_ENDPOINT)
			  .andReturn();
	}

	public Response updateUser(User user){
		return given(this.requestSpecification)
			  .body(user)
			  .when()
			  .post(USER_ENDPOINT + "/" + user.getUsername())
			  .andReturn();
	}

	public Response getUserByUsername(String username){
		return given(this.requestSpecification)
			  .when()
			  .post(USER_ENDPOINT + "/" + username)
			  .andReturn();
	}

	public Response deleteUserByUsername(String username){
		return given(this.requestSpecification)
			  .when()
			  .delete(USER_ENDPOINT + "/" + username)
			  .andReturn();
	}

}
