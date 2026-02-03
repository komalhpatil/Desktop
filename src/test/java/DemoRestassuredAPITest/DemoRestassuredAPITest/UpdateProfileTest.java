package DemoRestassuredAPITest.DemoRestassuredAPITest;

import org.testng.annotations.Test;

import BaseService.AuthService;
import BaseService.UserProfileManagementService;
import io.restassured.response.Response;
import models.request.LoginRequest;
import models.request.ProfileRequest;

import models.response.LoginResponse;
import models.response.UserProfileResponse;

public class UpdateProfileTest {
	
	
	@Test(description = "Verify if user is able to update the profile")

	public void patchProfileTest() {
				

		
		LoginRequest loginRequest = new LoginRequest("Komalp","koms123");
		AuthService  authService = new AuthService();
		System.out.println("******************************************************************");
		System.out.println(loginRequest);
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println("******************************************************************");
		System.out.println(response.asPrettyString());
		//System.out.println(loginResponse);
		//System.out.println(loginResponse.getToken());
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		// System.out.println(response.asPrettyString());
		 
		 UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		 System.out.println(response.asPrettyString());
		 System.out.println(userProfileResponse.getId());
		 System.out.println(userProfileResponse.getUsername());
		 System.out.println("******************************************************************");
	
		 	 
		 
		 
			ProfileRequest profileRequest = new ProfileRequest.Builder().firstName("Koma").lastName("Patil").mobileNumber("1111111111")
					.email("koms123").Build();
			//System.out.println(profileRequest);
		 response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
		System.out.println(response.asPrettyString());


}
}