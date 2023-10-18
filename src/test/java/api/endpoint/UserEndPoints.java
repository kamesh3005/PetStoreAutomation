package api.endpoint;
//userEndpoints.java

//create to perform Create,Read,update,delete request to the user API
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.response.Response;

public class UserEndPoints {
	
	
	public static Response createUser(User payload){
		
		
		Response rse=given()
		
		.contentType("application/json")
		.accept("application/json")
		.body(payload)
		
		.when()
		
		.post(Routes.post_url);
		return rse;
		
	}		
public static Response readUser(String username){
		
		
		Response rse=given()
		.pathParam("username", username)
		
		
		.when()
		
		.get(Routes.get_url);
		return rse;
		
	}	
public static Response updateUser(String username,User payload){
	
	
	Response rse=given()
	
	.contentType("application/json") 
	.accept("application/json")
	.pathParam("username", username)
	.body(payload)
	
	
	.when()
	
	.put(Routes.update_url);
	return rse;
	
}
public static Response deleteUser(String username){
	
	
	Response rse=given()
	.pathParam("username", username)
	
	
	.when()
	
	.delete(Routes.delete_url);
	return rse;
	
}
		
		
		
		
	
	
	
	

}
