package Mentor;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Mentor_GET_Req {

	@Test (priority = 0)
	public void get_categories() {

		// specify base URL

		RestAssured.baseURI = "http://simform.solutions:40210/api/v1/user";

		// Request Object
		RequestSpecification httpReq = RestAssured.given();

		// Response Object
		Response response = httpReq.request(Method.GET, "/categories");

		String ResponseBody = response.getBody().asString();

		System.out.println("Response Body is:" + ResponseBody);
		
		int statuscode = response.getStatusCode();	
		System.out.println("Status code is" + statuscode);
		
		long responsetime = response.getTime();
		System.out.println("Response time is" + responsetime);
		
		//Assert.assertEquals(1173, responsetime);
		if (responsetime > 1000 )
		{
			System.out.println("Response time is too long");
			
		}
		
		else 
		{
			
			System.out.println("Response time is proper");
			
		}
	}
	
	@Test (priority = 1)
	public void get_filter() {

		// specify base URL

		RestAssured.baseURI = "http://simform.solutions:40210/api/v1/user";

		// Request Object
		RequestSpecification httpReq = RestAssured.given();

		// Response Object
		Response response = httpReq.request(Method.GET, "/filters");

		String ResponseBody = response.getBody().asString();

		System.out.println("Response Body is:" + ResponseBody);
		
		int statuscode = response.getStatusCode();	
		System.out.println("Status code is" + statuscode);
		
		long responsetime = response.getTime();
		System.out.println("Response time is" + responsetime);
		
		//Assert.assertEquals(1173, responsetime);
		if (responsetime > 1000 )
		{
			System.out.println("Response time is too long");
			
		}
		
		else 
		{
			
			System.out.println("Response time is proper");
			
		}
	}
	@Test (priority = 2)
	public void get_Homedata() {

		// specify base URL

		RestAssured.baseURI = "http://simform.solutions:40210/api/v1/home";

		// Request Object
		RequestSpecification httpReq = RestAssured.given();

		// Response Object
		Response response = httpReq.request(Method.GET, "/data");

		String ResponseBody = response.getBody().asString();

		System.out.println("Response Body is:" + ResponseBody);
		
		int statuscode = response.getStatusCode();	
		System.out.println("Status code is" + statuscode);
		
		long responsetime = response.getTime();
		System.out.println("Response time is" + responsetime);
		
		//Assert.assertEquals(1173, responsetime);
		if (responsetime > 1000 )
		{
			System.out.println("Response time is too long");
			
		}
		
		else 
		{
			
			System.out.println("Response time is proper");
			
		}
	}
}
