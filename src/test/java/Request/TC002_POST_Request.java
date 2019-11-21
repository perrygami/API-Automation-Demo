package Request;

import java.util.HashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import QaUtil.TestUtil;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class TC002_POST_Request extends TestUtil {

	static String tokenS;
	TestUtil testutil;
	TC002_POST_Request tc_post_req;
	String sheetName = "sheet1";
	// String URL="http://simform.solutions:40210/api/v1/user";

	@DataProvider
	public Object[][] getTestData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

//	@Test(priority = 0, dataProvider = "getTestData")
//	public void Registration(String name, String email, String password) {
//
//		RestAssured.baseURI = "http://simform.solutions:40210/api/v1/user";
//
//		// Request Object
//		RequestSpecification httpReq = RestAssured.given();
//
//		// Response Object
//
//		// Body parameters sending with post request
//		JSONObject requestParams = new JSONObject();
//		// System.out.println(title);
//		requestParams.put("name", name);
//		requestParams.put("email", email);
//		requestParams.put("password", password);
//
//		httpReq.header("Content-Type", "application/json");
//
//		httpReq.body(requestParams.toJSONString());
//
//		Response response = httpReq.request(Method.POST, "/create");
//
//		String ResponseBody = response.getBody().asString();
//		System.out.println(ResponseBody);
//
//		int statuscode = response.getStatusCode();
//		System.out.println("Status code is" + statuscode);
//
//		response.jsonPath().get("Successcode");
//
//	}
//
	@Test(priority = 1)
	public void Login() {

		RestAssured.baseURI = "http://simform.solutions:40210/api/v1/user";

		// Request Object
		RequestSpecification httpReq = RestAssured.given();

		// Response Object

		// Body parameters sending with post request
		JSONObject requestParams = new JSONObject();

		// param for login
		requestParams.put("email", "testuser@mailinator.com");
		requestParams.put("password", "testuser.123");

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

	}

//	@Test(priority = 2)
//	public void Changepassword() {
//
//		RestAssured.baseURI = "http://simform.solutions:40210/api/v1/user";
//
//		// Request Object
//		RequestSpecification httpReq = RestAssured.given();
//
//		// Response Object
//
//		// Body parameters sending with post request
//		JSONObject requestParams = new JSONObject();
//
//		// param for login
//
//		requestParams.put("password", "testuser.123");
//
//		requestParams.put("newPassword", "testuser.123");
//
//		httpReq.header("Content-Type", "application/json");
//
//		httpReq.header("x-access-token", tokenS);
//
//		httpReq.body(requestParams.toJSONString());
//
//		Response response = httpReq.request(Method.POST, "/change-password");
//
//		String ResponseBody = response.getBody().asString();
//		System.out.println(ResponseBody);
//
//	}
//
//	@Test(priority = 3)
//	public void MyProfile() {
//
//		RestAssured.baseURI = "http://simform.solutions:40210/api/v1/user";
//
//		// Request Object
//		RequestSpecification httpReq = RestAssured.given();
//
//		// Response Object
//
//		// Body parameters sending with post request
//		JSONObject requestParams = new JSONObject();
//
//		httpReq.header("Content-Type", "application/json");
//
//		httpReq.header("x-access-token", tokenS);
//		httpReq.body(requestParams.toJSONString());
//
//		Response response = httpReq.request(Method.GET, "/my-profile");
//
//		String ResponseBody = response.getBody().asString();
//		System.out.println(ResponseBody);
//
//	}

	@Test(priority = 4)
	public void Upload_Profile_Picture() {

		RestAssured.baseURI = "http://172.16.0.132:40210/api/v1/user/";

		// Request Objectissue
		RequestSpecification httpReq = RestAssured.given();

		// Response Object

		// Body parameters sending with post request
		JSONObject requestParams = new JSONObject();

		String appPath = System.getProperty("user.dir") + "/Test_yourself.png";

		httpReq.multiPart("image", new File(appPath));
		httpReq.header("Content-Type", "multipart/form-data");

		httpReq.header("x-access-token", tokenS);
		httpReq.body(requestParams.toJSONString());

		Response response = httpReq.request(Method.POST, "/upload-profile");

		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);

	}
}
