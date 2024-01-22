package steps;

import org.json.simple.JSONObject;
import org.testng.Assert;

import core.APIHelper;
import core.APIRequest;
import core.JsonProcessor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class PatchTypeDefinition {
	
	
	public JSONObject jsonObject;
	public APIRequest apiPatch;
	public Response response;
	public JsonProcessor obj;
	public APIHelper apiHelper;

	@Given("The user details which needs to be updated in partially")
	public void the_user_details_which_needs_to_be_updated_in_partially() {

		obj = new JsonProcessor();
		jsonObject = obj.readFromJsonFile(
				"C:\\Users\\hp\\eclipse-workspace1\\API_Framework3_New\\src\\main\\java\\Files\\patch1.json");
		apiPatch = new APIRequest(jsonObject.get("requestType").toString(), jsonObject.get("requestApiPath").toString());
		jsonObject.get("requestBody").toString();
	}

	@When("The admin user submits the user details which will be updated in partially")
	public void the_admin_user_submits_the_user_details_which_will_be_updated_in_partially() {


		apiHelper = new APIHelper();
		response = apiHelper.hitAPI(apiPatch);

	}

	@Then("The user is updated in partially successfull")
	public void the_user_is_updated_in_partially_successfull() {
		Assert.assertEquals(200, response.getStatusCode());

	}

}
