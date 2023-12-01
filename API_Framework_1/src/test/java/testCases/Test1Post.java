package testCases;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import Core.APIHelper;
import Core.APIRequest;
import Core.JsonProcessor;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Test1Post {
@Test 

	public void test()
	{
	 HashMap<String, String> headers = new HashMap<String, String>();
	 headers.put("Content-Type","application/json");
	
	 JSONObject requestObject = new JSONObject();
	 requestObject.put( "name","morpheus");
	 requestObject.put(  "job", "leader");
	 
	 APIRequest apiPost = new APIRequest("post","/api/users",headers,requestObject);
	 
	 APIHelper apiHelper = new APIHelper();
	 Response response = apiHelper.hitAPI(apiPost);
	
	 Assert.assertEquals(201, response.getStatusCode());
		
	}
}
