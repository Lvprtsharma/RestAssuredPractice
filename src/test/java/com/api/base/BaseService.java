package com.api.base;

import static io.restassured.RestAssured.*;

import com.pai.models.request.LoginRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	// Wrapper for Rest Assured
	// Base URI
	// Creating the request 
	// Handling the response

	private static final String BASE_URI = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
 
	public BaseService() {
		requestSpecification = given().baseUri(BASE_URI);
	}

	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization", "Bearer " + token);
	}
	
	protected Response postRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}

	protected Response postRequest(String baseUri, Object payload, String endpoint) {
		return requestSpecification.baseUri(baseUri).contentType(ContentType.JSON).body(payload).post(endpoint);
	}

	protected Response getRequest(String endpoint) {
		return requestSpecification.get(endpoint);
	}


}
