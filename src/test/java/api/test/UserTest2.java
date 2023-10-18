package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.UserEndPoints;
import api.endpoint.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest2 {
	
	Faker faker;
	User userPayload;
	public Logger log;
	
	@BeforeClass
	
	public void setupData() {
		
		faker=new Faker();
		userPayload=new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload	.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		//logs
		log=LogManager.getLogger(this.getClass());


		

		
		
	}
	
	
	@Test(priority = 1)
	void testPostUser() {
		log.info("******Create User********");
		
		Response response = UserEndPoints2.createUser(userPayload);
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		log.info("******Create User Pass Successfully********");

		
		
	}
	
	@Test(priority = 2)
	
	void testgetUsers() {
		log.info("******Get User********");

		
		Response respone = UserEndPoints2.readUser(this.userPayload.getUsername());
		respone.then().log().all();
		AssertJUnit.assertEquals(respone.getStatusCode(), 200);
		log.info("******Get User Pass Successfully********");

	}
	
	@Test(priority = 3)
	void testUpdateUser() {
		log.info("******Update User********");

		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints2.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		//Response after update
		
		Response responeAfter_update = UserEndPoints2.readUser(this.userPayload.getUsername());
		responeAfter_update.then().log().all();
		AssertJUnit.assertEquals(responeAfter_update.getStatusCode(), 200);
		log.info("******update User Pass Successfully********");

		
		
	}
	
	@Test(priority = 4)
	void testDeleteUser() {
		log.info("******Delete User********");

		
		Response deleteUser = UserEndPoints2.deleteUser(this.userPayload.getUsername());
		
		AssertJUnit.assertEquals(deleteUser.getStatusCode(), 200);
		log.info("******Delet User Pass Successfully********");

	}
	
	

}
