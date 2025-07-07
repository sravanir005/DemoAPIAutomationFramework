package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test(description="Verify if update profile api is working...")
	public void updateProfileTest()
	{
		AuthService authService=new AuthService();
		Response response=authService.login(new LoginRequest("sravs1507","S19ravani99@"));
		LoginResponse loginResponse=response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		
		System.out.println("------------------------------------------------------------");
		
		UserService userService=new UserService();
		response=userService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse=response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(),"sravs1507");
		
		System.out.println("--------------------------------------------------------------");
		
		ProfileRequest profileRequest=new ProfileRequest.Builder().
				firstName("sravs")
				.lastName("reddy")
				.email("sravanir150799@gmail.com")
				.mobileNumber("8989854321").build();
		
		response=userService.updateProfile(loginResponse.getToken(), profileRequest);
		System.out.println(response.asPrettyString());
				
	}
}
