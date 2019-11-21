package Mentor;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Mentor_POST_Req {
	static String tokenS;
	@Test
	public void GetMentors() {

		RestAssured.baseURI = "http://simform.solutions:40210/api/v1/user";

		// Request Object
		RequestSpecification httpReq = RestAssured.given();

		// Response Object

		// Body parameters sending with post request
		JSONObject requestParams = new JSONObject();

		httpReq.header("Content-Type", "application/json");

		//httpReq.header("x-access-token", tokenS);
		httpReq.body(requestParams.toJSONString());

		Response response = httpReq.request(Method.POST, "/mentors");

		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);

	}

	@Test
	public void GetMentordetail() {

		RestAssured.baseURI = "http://simform.solutions:40210/api/v1/user";

		// Request Object
		RequestSpecification httpReq = RestAssured.given();

		// Response Object

		// Body parameters sending with post request
		JSONObject requestParams = new JSONObject();

		requestParams.put("mentorId", 80);
		httpReq.header("Content-Type", "application/json");

		//httpReq.header("x-access-token", tokenS);
		httpReq.body(requestParams.toJSONString());

		Response response = httpReq.request(Method.POST, "/mentor-detail");

		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
		

	}

	@Test(priority = 1)
	public void Login() {

		RestAssured.baseURI = "http://172.16.0.132:40210/api/v1/user";

		// Request Object
		RequestSpecification httpReq = RestAssured.given();

		// Response Object

		// Body parameters sending with post request
		JSONObject requestParams = new JSONObject();

		// param for login
		requestParams.put("email", "testuser@mailinator.com");
		requestParams.put("password","testuser.123");

		httpReq.header("Content-Type", "application/json");

		httpReq.body(requestParams.toJSONString());

		Response response = httpReq.request(Method.POST, "/login");

		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);

		int statuscode = response.getStatusCode();
		System.out.println("Status code is" + statuscode);

		// Object token = ((HashMap) response.jsonPath().get("data")).get("token");
		tokenS = ((HashMap) response.jsonPath().get("data")).get("token").toString();
		System.out.println("token is:" + tokenS);
}}
