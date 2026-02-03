package BaseService;

import io.restassured.response.Response;
import models.request.ProfileRequest;

public class UserProfileManagementService extends BaseService
{
	private static final String BASE_PATH = "/api/users";
	
	
	public Response getProfile(String token)
	
	{   //System.out.println(token);
		setAuthToken(token);
		
		return getRequest(BASE_PATH+"/profile");
    }
	
	
	public Response updateProfile(String token, ProfileRequest payload)
	
	{   
		setAuthToken(token);
		return patchRequest(payload, BASE_PATH+"/profile");
    }
}