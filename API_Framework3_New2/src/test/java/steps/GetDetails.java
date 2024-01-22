package steps;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;

import core.APIHelper;
import core.APIRequest;
import core.JsonProcessor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;


public class GetDetails {
	
	//Instance variables
	public APIRequest apiRequest;
	public Response response;
	public String filePath;
	public JSONObject jsonObject;
	
	
	//Scenario 1
	//Step 1
	@Given("The users whose details need to be retrieved")
	public void the_users_whose_details_need_to_be_retrieved() {
		
		//Creating the Request object
		apiRequest = new APIRequest("get", "/api/users?page=2");
		
	}

	//Step 2
	@When("The admin user submits the users whose details need to be retrieved")
	public void the_admin_user_submits_the_users_whose_details_need_to_be_retrieved() {
		
		//Creating object of APIHelper & calling the hitAPI() method using this object and obtaining the response
		APIHelper apiHelper = new APIHelper();
		response = apiHelper.hitAPI(apiRequest);
		
	}

	//Step 3
	@Then("The users details should be retrieved successfully")
	public void the_users_details_should_be_retrieved_successfully() {

		//Console output of the response body and headers
		System.out.println(response.getBody().asPrettyString());
		System.out.println(response.getHeaders());
				
		//Asserting the response details
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getContentType(),"application/json; charset=utf-8");
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		Assert.assertTrue(response.getTimeIn(TimeUnit.MILLISECONDS)<5000);
		
	}
	
	
}