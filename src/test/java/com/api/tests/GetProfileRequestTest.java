package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.pai.models.request.LoginRequest;
import com.pai.models.response.LoginResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {
	
	@Test(description = "Verify if Profile API is working...")
	public void getProfileInfoTest() {
		LoginRequest loginRequest = new LoginRequest("harry.sharma", "Test@123");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		System.out.println(loginResponse.getToken());
		UserProfileManagementService upm = new UserProfileManagementService();
		response = upm.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
	}

}
