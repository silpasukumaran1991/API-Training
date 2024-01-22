package testCases;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.APIHelper;
import core.APIRequest;
import io.restassured.response.Response;

public class Test2Post {
	
	@Test(enabled=false) 

	public void registerSuccessful()
	{
	 HashMap<String, String> headers = new HashMap<String, String>();
	 headers.put("Content-Type","text/plain");
	
	 JSONObject requestObject = new JSONObject();
	 requestObject.put("email","eve.holt@reqres.in");
	 requestObject.put("password", "pistol");
	 
	 APIRequest apiPost = new APIRequest("post","/api/register",headers,requestObject);
	 
	 APIHelper apiHelper = new APIHelper();
	 Response response = apiHelper.hitAPI(apiPost);
	 
	 System.out.println(response.asString());
	 System.out.println(response.getStatusCode());
	 Assert.assertEquals(201, response.getStatusCode());
		
	}
	

	
	
	 @Test(enabled = true)
		
	 public void RegisterSucessfull1() {

		 HashMap<String, String> headers = new HashMap<String, String>();
			headers.put("Content-Type", "text/plain");
			JSONObject requestObject = new JSONObject();
			requestObject.put("email", "eve.holt@reqres.in");
			requestObject.put("password", "pistol");
			APIRequest apiRequestPost = new APIRequest("post", "/api/users", headers, requestObject);
			APIHelper apiHelper = new APIHelper();
			Response response = apiHelper.hitAPI(apiRequestPost);
			Assert.assertEquals(201, response.getStatusCode());
			
			 System.out.println(response.asPrettyString());
			 Assert.assertEquals("HTTP/1.1 201 Created",response.getStatusLine());		 
			
		}
	 
	
	
	
	
	@Test(enabled=true)

	public void registerUnsuccessful()
	{
	 HashMap<String, String> headers = new HashMap<String, String>();
	 headers.put("Content-Type","application/json");
	
	 JSONObject requestObject = new JSONObject();
	 requestObject.put( "email","sydney@fife");
	 
	 
	 APIRequest apiPost = new APIRequest("post","/api/register",headers,requestObject);
	 
	 APIHelper apiHelper = new APIHelper();
	 Response response = apiHelper.hitAPI(apiPost);
	 System.out.println(response.asString());
	
	 Assert.assertEquals(400, response.getStatusCode());
		
	}
	
	
	
	
	
	@Test(enabled=true)

	public void loginSuccessful4()
	{
	 HashMap<String, String> headers = new HashMap<String, String>();
	 headers.put("Content-Type","application/json");
	
	 JSONObject requestObject = new JSONObject();
	 requestObject.put("email","eve.holt@reqres.in");
	 requestObject.put( "password","cityslicka");	
	 	
	  
	 APIRequest apiPost = new APIRequest("post","api/login",headers,requestObject);
	 
	 APIHelper apiHelper = new APIHelper();
	 Response response = apiHelper.hitAPI(apiPost);
	 System.out.println(response.asString());
	
	 Assert.assertEquals(200, response.getStatusCode());
		
	}


	@Test(enabled=true)

	public void loginUnsuccessful()
	{
	 HashMap<String, String> headers = new HashMap<String, String>();
	 headers.put("Content-Type","application/json");
	
	 JSONObject requestObject = new JSONObject();
	 requestObject.put("email","peter@klaven");
		
	 	
	 
	 
	 APIRequest apiPost = new APIRequest("post","api/login",headers,requestObject);
	 
	 APIHelper apiHelper = new APIHelper();
	 Response response = apiHelper.hitAPI(apiPost);
	 System.out.println(response.asString());
	
	 Assert.assertEquals(400, response.getStatusCode());
		
	}
}
