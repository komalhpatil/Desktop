package DemoRestassuredAPITest.DemoRestassuredAPITest;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseService.AuthService;
import io.restassured.response.Response;
import models.request.SignUpRequest;

public class AccountCreationTest {
	
	@Test(description = "Verify if SignUp workflow is working")

	public void createAccountTest() {
		SignUpRequest signUpRequest = new SignUpRequest.Builder().username("Komalp").email("komalhpatil@gmail.com").firstName("Komal")
		.lastName("Patil").mobileNumber("1111111111").password("koms123").Build();
		
		AuthService  authService = new AuthService();
		
		Response response = authService.signUp(signUpRequest);
		//System.out.println(response.asPrettyString());
		Assert.assertEquals(response.asPrettyString(),"Error: Username is already taken!");

}
}