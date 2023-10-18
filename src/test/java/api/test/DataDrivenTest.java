package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoint.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTest {

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)

	public void testPostUser(String userid, String userName, String fname,String lname, String email, String pass,
			String pho) {
		
		User userpayLoad=new User();
		userpayLoad.setId(Integer.parseInt(userid));
		userpayLoad.setUsername(userName);
		userpayLoad.setFirstName(fname);
		userpayLoad.setLastName(lname);
		userpayLoad.setEmail(email);
		userpayLoad.setPassword(pass);
		userpayLoad.setPhone(pho);
		
		Response response = UserEndPoints.createUser(userpayLoad);
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	@Test (priority = 2,dataProvider = "UserName",dataProviderClass = DataProviders.class)
	
	public void testgetData(String username) {
		
		Response readUser = UserEndPoints.readUser(username);
		readUser.then().log().all();
		AssertJUnit.assertEquals(readUser.getStatusCode(), 200);
	}
	
	@Test(priority = 3,dataProvider = "UserName",dataProviderClass = DataProviders.class)
	
	public void testDeleteUserName(String UserName) {
		Response deleteUser = UserEndPoints.deleteUser(UserName);
		
		AssertJUnit.assertEquals(deleteUser.getStatusCode(), 200);
		
		
		
		

	}

}
