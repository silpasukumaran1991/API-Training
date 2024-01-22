package steps;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;

import core.APIHelper;
import core.APIRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;


@SuppressWarnings("unchecke")
public class PutTypeDefinition {
	
	public APIRequest apiRequestPut;
	public Response response;
	public HashMap<String, String> headers;
	public JSONObject requestObject;
	public String filePath;
	public HashMap<String, String> metaInfo;
	public JSONObject jsonObj;
	public JSONObject requestJSONObject;

	
	@Given("The user details which needs to be updated")
	public void the_user_details_which_needs_to_be_updated() {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
	   requestObject = new JSONObject();
		requestObject.put("name","morpheus");
		requestObject.put("job","zion resident");

	}

	@When("The admin user submits the user details which will be updated")
	public void the_admin_user_submits_the_user_details_which_will_be_updated() {
		apiRequestPut = new APIRequest("put","/api/users/2",headers,requestObject);
		APIHelper apiHelper = new APIHelper();
		response = apiHelper.hitAPI(apiRequestPut);
	}

	@Then("The user is updated successfully")
	public void the_user_is_updated_successfully() {
		Assert.assertEquals(200, response.getStatusCode());

	}

}
