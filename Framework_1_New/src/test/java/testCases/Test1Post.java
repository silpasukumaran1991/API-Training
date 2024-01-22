package testCases;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.APIHelper;
import core.APIRequest;
import core.JsonProcessor;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import requestpojo.RequestPojoPost;

public class Test1Post {
@Test(enabled = true)

	public void createPostType1()
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


@Test(enabled = true)

public void createPostType2()
{ 
 JsonProcessor obj = new JsonProcessor();
 JSONObject jsonObject = obj.readFromJsonFile("C:\\Users\\hp\\git\\API-Training\\API_Framework_1\\src\\main\\resources\\apis\\api3.json");
 APIRequest apiPost = new APIRequest(jsonObject.get("requestType").toString(),
 jsonObject.get("requestApiPath").toString());
 jsonObject.get("requestBody").toString();

 APIHelper apiHelper = new APIHelper();
 Response response = apiHelper.hitAPI(apiPost);
 Assert.assertEquals(201, response.getStatusCode());
	
}


@Test(enabled = true)
public void testPostUsingOrchestrate() {
	HashMap<String,String> metaInfo=new HashMap<String,String>();

	metaInfo.put("name", "silpa");
	metaInfo.put("job", "developer");
	
	
	APIRequest apiRequestPost = new APIRequest(
			"C:\\Users\\hp\\git\\API-Training\\API_Framework_1\\src\\main\\resources\\apis\\api2.json",metaInfo);
	APIHelper apiHelper = new APIHelper();
	Response response = apiHelper.hitAPI(apiRequestPost);
	System.out.println(response.getStatusCode());
	Assert.assertEquals(201, response.getStatusCode());
}





@Test(enabled =true)
public void testPostUsingOrchestrateionUsingRequestPojo() {
	RequestPojoPost objReq=new RequestPojoPost();
	objReq.setName("silpa");
	objReq.setJob("leader");
	HashMap<String,String>Headers=new HashMap<String,String>();
	System.out.println(objReq);
	JsonProcessor obj = new JsonProcessor();
	JSONObject jsonObject = obj.readFromJsonFile(
			"C:\\Users\\hp\\git\\API-Training\\API_Framework_1\\src\\main\\resources\\apis\\api2.json");
	System.out.println(jsonObject.get("requestType"));
	APIRequest apiRequest = new APIRequest(jsonObject.get("requestType").toString(),
			jsonObject.get("requestApiPath").toString(),Headers,JsonProcessor.stringToJsonObject(objReq.toString())); 
	APIHelper apiHelper = new APIHelper();
	Response response = apiHelper.hitAPI(apiRequest);
	System.out.println(response.getStatusCode());

}




}
