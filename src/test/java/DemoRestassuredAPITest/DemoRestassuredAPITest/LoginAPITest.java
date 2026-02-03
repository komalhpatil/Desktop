package DemoRestassuredAPITest.DemoRestassuredAPITest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseService.AuthService;
import Listeners.TestListeners;
import io.restassured.response.Response;
import models.request.LoginRequest;
import models.response.LoginResponse;

@Listeners(TestListeners.class)

public class LoginAPITest {
	
	
	
	
	@Test(description = "Verify if Login API is working")

	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("Komalp","koms123");
		AuthService  authService = new AuthService();
		Response response = authService.login(loginRequest);
					
		LoginResponse loginResponse = response.as(LoginResponse.class);
		//System.out.println(response.asPrettyString());
		//System.out.println("Token = " + loginResponse.getToken());
		
		Assert.assertTrue(loginResponse.getToken()!= null);
		Assert.assertEquals(loginResponse.getEmail(),"komalhpatil@gmail.com");
		
			}

	

	
}


