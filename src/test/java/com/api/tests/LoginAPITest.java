package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import com.api.base.AuthService;
import com.pai.models.request.LoginRequest;
import com.pai.models.response.LoginResponse;

public class LoginAPITest {
	
	@Test(description = "Verify if Login API is working...")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("harry.sharma", "Test@123");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getUsername());
		System.out.println(loginResponse.getId());
		
		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getUsername(), "harry.sharma");
		Assert.assertEquals(loginResponse.getId(), 433);
		

	}

}
