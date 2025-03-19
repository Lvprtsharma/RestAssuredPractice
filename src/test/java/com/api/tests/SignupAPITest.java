package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.pai.models.request.LoginRequest;
import com.pai.models.request.SignUpRequest;
import com.pai.models.response.LoginResponse;

import io.restassured.response.Response;

public class SignupAPITest {

	@Test(description = "Verify if Signup API is working...")
	public void signupTest() {

		SignUpRequest signup =  new SignUpRequest.Builder()
		.email("john1234@gmail.com")
		.firstName("John")
		.lastName("Paul")
		.mobileNumber("9879879877")
		.password("Test@123")
		.username("johnpaul1234")
		.build();
		
		AuthService authService = new AuthService();
		Response response = authService.signup(signup);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
	}

}
