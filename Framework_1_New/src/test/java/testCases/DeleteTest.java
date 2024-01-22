package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import core.APIHelper;
import core.APIRequest;
import core.JsonProcessor;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import pojo.ListUsers;

public class DeleteTest {
	
	
	@Test(enabled= true )
	  public void deleteUser() {
		  

		  APIRequest apiRequest = new APIRequest("C:\\Users\\hp\\git\\API-Training\\API_Framework_1\\src\\main\\resources\\apis\\delete.json");
			APIHelper apiHelper = new APIHelper();
			Response response = apiHelper.hitAPI(apiRequest);
			System.out.println(response.getStatusCode());
			Assert.assertEquals(204, response.getStatusCode());
			
		}

	@Test(enabled = true)
	public void testDeleteUser() {
	
		JsonProcessor obj = new JsonProcessor();
		org.json.simple.JSONObject jsonObject = obj.readFromJsonFile("C:\\Users\\hp\\git\\API-Training\\API_Framework_1\\src\\main\\resources\\apis\\delete.json");
		System.out.println(jsonObject.get("requestType").toString());
		APIRequest apiRequest = new APIRequest(jsonObject.get("requestType").toString(),
				jsonObject.get("requestApiPath").toString());
		System.out.println(jsonObject.get("requestApiPath").toString());

		APIHelper apiHelper = new APIHelper();
		Response response = apiHelper.hitAPI(apiRequest);
		System.out.println(response.getStatusCode());
	//	Assert.assertEquals(204, response.getStatusCode());
		
		
	
	}	


}
