package DemoRestassuredAPITest.DemoRestassuredAPITest;

import org.testng.annotations.Test;

import BaseService.AuthService;
import io.restassured.response.Response;


public class ForgotPasswordTest {
	
	@Test(description = "Verify if forgot Password is working")

	public void forgotPasswordTest() {
		
		AuthService  authService = new AuthService();
		Response response = authService.forgotPassword("komalhpatil@gmail.com");
		System.out.println(response.asPrettyString());
					
	

}}