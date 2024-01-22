package steps;

import org.json.simple.JSONObject;
import org.testng.Assert;

import core.APIHelper;
import core.APIRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class GetSingleUsers {

	public APIRequest apiRequest;
	public Response response;
	public String filePath;
	public JSONObject jsonObject;

	@Given("The system should shows single user details")
	public void the_system_should_shows_single_user_details() {
		apiRequest = new APIRequest("get", "/api/users/2");

	}

	@When("Hit the get single user api")
	public void hit_the_get_single_user_api() {
		APIHelper apiHelper = new APIHelper();
		response = apiHelper.hitAPI(apiRequest);
	}

	@Then("The single users details should retrieved successfully")
	public void the_single_users_details_should_retrieved_successfully() {

		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}

}