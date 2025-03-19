package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.pai.models.request.LoginRequest;
import com.pai.models.response.LoginResponse;

import io.restassured.response.Response;

public class ForgotPasswordTest {

	@Test(description = "Verify if Forgot API is working...")
	public void forgotPasswordTest() {

		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("john1234@gmail.com");
		System.out.println(response.asPrettyString());
	}
}
