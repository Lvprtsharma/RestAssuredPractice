package com.api.base;

import java.util.HashMap;

import com.pai.models.request.LoginRequest;
import com.pai.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService {

	private static final String BASE_PATH = "/api/auth/";

	public Response login(LoginRequest payload) {
		return postRequest(payload, BASE_PATH + "login");
	}
	
	public Response signup(SignUpRequest payload) {
		return postRequest(payload, BASE_PATH + "signup");
	}

	public Response forgotPassword(String email) {
		HashMap<String, String> payload = new HashMap<String, String>();
		payload.put("email", email);
		return postRequest(payload, BASE_PATH + "forgot-password");
	}
	
}
