package testCases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import core.APIHelper;
import core.APIRequest;
import core.JsonProcessor;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;
import pojo.ListUsers;
import pojo.SingleUser;
import pojo.listResources;


public class Test2Get {
	@Test(enabled = false)
	public void singleUser() {
		APIRequest apirequest = new APIRequest("get", "/api/users/2");
		APIHelper apiHelper = new APIHelper();
		Response response = apiHelper.hitAPI(apirequest);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		JSONObject jsonObj = JsonProcessor.stringToJsonObject(response.asString());
		// System.out.println(jsonObj.toString());

		// use pojo classes -2nd method

		SingleUser SingleUser = null;

		ObjectMapper om = new ObjectMapper();
		try {
			SingleUser = om.readValue(jsonObj.toString(), SingleUser.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(SingleUser.data.email);
		String email = SingleUser.data.email;
		Assert.assertEquals("janet.weaver@reqres.in", email);
		System.out.println(SingleUser.getSupport().getUrl());
		String supportUrl = SingleUser.getSupport().getUrl();
		Assert.assertEquals("https://reqres.in/#support-heading", supportUrl);

	}

	@Test(enabled = true)
	public void singleUserNotFound() {
		JsonProcessor obj = new JsonProcessor();
		JSONObject jsonObject = obj.readFromJsonFile(
				"C:\\Users\\hp\\git\\API-Training\\API_Framework_1\\src\\main\\resources\\apis\\notFounf.json");
		System.out.println(jsonObject.get("requestType"));
		APIRequest apiRequest = new APIRequest(jsonObject.get("requestType").toString(),
				jsonObject.get("requestApiPath").toString());
		APIHelper apiHelper = new APIHelper();
		Response response = apiHelper.hitAPI(apiRequest);

		JSONObject jsonObj = JsonProcessor.stringToJsonObject(response.asString());
		System.out.println(jsonObj.toString());

	}
	
	
	@Test(enabled = true)
	public static void listResourcesTest() {
		APIRequest apirequest = new APIRequest("get", "/api/unknown");
		APIHelper apiHelper = new APIHelper();
		Response response = apiHelper.hitAPI(apirequest);

		JSONObject jsonObj = JsonProcessor.stringToJsonObject(response.asString());
		System.out.println(jsonObj.toString());

		// use pojo classes -2nd method

		listResources listResources = null;

		ObjectMapper om = new ObjectMapper();
		try {
			listResources = om.readValue(jsonObj.toString(), listResources.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		int page = listResources.page;
		Assert.assertEquals(1, page);
		
	}

}
