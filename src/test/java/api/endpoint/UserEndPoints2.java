package api.endpoint;
//userEndpoints.java

//create to perform Create,Read,update,delete request to the user API
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.response.Response;

public class UserEndPoints2 {
	
	
	//method to create for getting URL from the properties file
	public static ResourceBundle getUrl() {
		
		ResourceBundle routes = ResourceBundle.getBundle("routes");//To load the properties file
		return routes;
	}
	
	
	public static Response createUser(User payload){
		String post_url = getUrl().getString("post_url");
		
		Response rse=given()
		
		.contentType("application/json")
		.accept("application/json")
		.body(payload)
		
		.when()
		
		.post(post_url);
		return rse;
		
	}		
public static Response readUser(String username){
	String get_url = getUrl().getString("get_url");

		
		
		Response rse=given()
		.pathParam("username", username)
		
		
		.when()
		
		.get(get_url);
		return rse;
		
	}	
public static Response updateUser(String username,User payload){
	String update_url = getUrl().getString("update_url");

	
	
	Response rse=given()
	
	.contentType("application/json") 
	.accept("application/json")
	.pathParam("username", username)
	.body(payload)
	
	
	.when()
	
	.put(update_url);
	return rse;
	
}
public static Response deleteUser(String username){
	String delete_url = getUrl().getString("delete_url");

	
	
	Response rse=given()
	.pathParam("username", username)
	
	
	.when()
	
	.delete(delete_url);
	return rse;
	
}
		
		
		
		
	
	
	
	

}
