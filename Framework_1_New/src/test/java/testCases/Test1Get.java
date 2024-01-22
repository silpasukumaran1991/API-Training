package testCases;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import core.APIHelper;
import core.APIRequest;
import core.JsonProcessor;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.ListUsers;

public class Test1Get {
	
	
	@Test(enabled = true)
	public void getListUsers()
	{
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification httpRequest = RestAssured.given(); 
		Response response = httpRequest.get();
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	    System.out.println(response.getBody().asString());
		System.out.println(response.asPrettyString());
	   //To verify the response details - Create  a pojo class and call the details
		
		ListUsers listUser = null;
		ObjectMapper om = new ObjectMapper();
		try {
			listUser = om.readValue(response.asString(), ListUsers.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(listUser.support.url);
		int page = listUser.page;
		Assert.assertEquals(1, page);
		int totalPages =listUser.total;
		Assert.assertEquals(totalPages,12);

		int dataArraySize = listUser.data.size();
		Assert.assertEquals(dataArraySize, 6);
		
	/*	int dataArrayId = listUser.data.get(0).getId();
		Assert.assertEquals(dataArrayId, 7);
	
		if(listUser.data.get(1).getId()==8 && listUser.data.get(1).getFirst_name()=="Lindsay")
		{
	Assert.assertEquals("lindsay.ferguson@reqres.in",(listUser.data.get(1).getEmail()));
}*/
		
	}

		

	
  @Test(enabled= true )
  public void getListUsersType2() {
	  

	  APIRequest apiRequest = new APIRequest("C:\\Users\\hp\\git\\API-Training\\API_Framework_1\\src\\main\\resources\\apis\\api1.json");
		APIHelper apiHelper = new APIHelper();
		Response response = apiHelper.hitAPI(apiRequest);
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.body());
		System.out.println(response.asPrettyString());		
	//	JSONObject jsonObj = JsonProcessor.stringToJsonObject(response.asString());
		// JsonPath - 1st method (suport.data)
		// use pojo classes -2nd method

		ListUsers listUser = null;
		ObjectMapper om = new ObjectMapper();
		try {
			listUser = om.readValue(response.asString(), ListUsers.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(listUser.getPage());
		System.out.println(listUser.support.url);
		
	}

  
  
  
  @Test(enabled= true)
  public void getListUsersType3() {
	  
	    APIRequest apiRequest = new APIRequest("get", "/api/users?page=2");
		APIHelper apiHelper = new APIHelper();
		Response response = apiHelper.hitAPI(apiRequest);
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.body());
		System.out.println(response.asPrettyString());		
	//	JSONObject jsonObj = JsonProcessor.stringToJsonObject(response.asString());
		// JsonPath - 1st method (suport.data)
		// use pojo classes -2nd method

		ListUsers listUser = null;
		ObjectMapper om = new ObjectMapper();
		try {
			listUser = om.readValue(response.asString(), ListUsers.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(listUser.getPage());
		System.out.println(listUser.support.url);
		
	}
  
  
  
  @Test(enabled= true)
  public void getListUsersType4() {
	  
	  JsonProcessor obj = new JsonProcessor();
		JSONObject jsonObject = obj.readFromJsonFile(
				"C:\\Users\\hp\\git\\API-Training\\API_Framework_1\\src\\main\\resources\\apis\\api1.json");
		System.out.println(jsonObject.get("requestType"));
		APIRequest apiRequest = new APIRequest(jsonObject.get("requestType").toString(),
				jsonObject.get("requestApiPath").toString());
		APIHelper apiHelper = new APIHelper();
		Response response = apiHelper.hitAPI(apiRequest);
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.body());
		System.out.println(response.asPrettyString());		

		// JsonPath - 1st method (suport.data)
		// use pojo classes -2nd method

		ListUsers listUser = null;
		ObjectMapper om = new ObjectMapper();
		try {
			listUser = om.readValue(response.asString(), ListUsers.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(listUser.getPage());
		System.out.println(listUser.support.url);		
	}

}

