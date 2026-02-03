package DemoRestassuredAPITest.DemoRestassuredAPITest;

import org.testng.annotations.Test;

import BaseService.AuthService;
import BaseService.UserProfileManagementService;
import io.restassured.response.Response;
import models.request.LoginRequest;
import models.response.LoginResponse;
import models.response.UserProfileResponse;

public class GetProfileRequestTest {

		
		@Test(description = "Verify if user is able to fetch the profile")

		public void fetchProfileTest() {
			
			LoginRequest loginRequest = new LoginRequest("Komalp","koms123");
			
			AuthService  authService = new AuthService();
			Response response = authService.login(loginRequest);
			LoginResponse loginResponse = response.as(LoginResponse.class);
			
			//System.out.println(response.asPrettyString());
			//System.out.println(loginResponse);
			//System.out.println(loginResponse.getToken());
			
			UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
					
			 response = userProfileManagementService.getProfile(loginResponse.getToken());
			// System.out.println(response.asPrettyString());
			 
			 UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
			 System.out.println(userProfileResponse.getId());
			 System.out.println(userProfileResponse.getUsername());
		
			

}
}