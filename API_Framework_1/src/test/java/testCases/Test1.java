package testCases;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Core.APIHelper;
import Core.APIRequest;
import Core.JsonProcessor;
import Pojo.ListUsers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test1 {
  @Test
  public void f() {
	  
	  APIRequest apiRequest = new APIRequest("get", "/api/users?page=2");

		APIHelper apiHelper = new APIHelper();
		
		Response response = apiHelper.hitAPI(apiRequest);
		
		JSONObject jsonObj = JsonProcessor.stringToJsonObject(response.asString());

		// JsonPath - 1st method (suport.data)
		// use pojo classes -2nd method

		ListUsers listUser = null;

		ObjectMapper om = new ObjectMapper();
		try {
			listUser = om.readValue(jsonObj.toString(), ListUsers.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(listUser.getSupport().getUrl());

	}

}
