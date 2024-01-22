
package steps;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.Assert;

import core.APIHelper;
import core.APIRequest;
import core.JsonProcessor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import requestPojo.RequestPojoPost;
@SuppressWarnings("unchecked")
public class PostTypeDefinition {
	
	//Instance variables
	public HashMap<String, String> headers;
	public JSONObject requestObject;
	public APIRequest apiRequestPost;
	public Response response;
	public String filePath;
	public HashMap<String,String> metaInfo;
	public JSONObject requestBody;
	APIRequest apiRequest;
	JSONObject jsonObj;
	JSONObject requestJSONObject;
	public APIRequest apiPost;

//Scenario 1
	//Step 1
	@Given("The user details which needs to be created")
	public void the_user_details_which_needs_to_be_created() {
		
		//Request headers	
		headers = new HashMap<String, String>();
		headers.put("Content-Type","application/json");
		headers.put("Accept","*/*");
		headers.put("Connection","keep-alive");
			
		//Request body
		requestObject = new JSONObject();
		requestObject.put( "name","morpheus");
		requestObject.put(  "job", "leader");
			 
		//Creating the Request object
		apiRequestPost = new APIRequest("post","/api/users",headers,requestObject);
	}

	//Step 2
	@When("The admin user submits the user details which will be created")
	public void the_admin_user_submits_the_user_details_which_will_be_created() {
		
		//Creating object of APIHelper & calling the hitAPI() method using this object and obtaining the response	
		APIHelper apiHelper = new APIHelper();
		response = apiHelper.hitAPI(apiRequestPost);
		
	}

	//Step 3
	@Then("The user should be created successfully")
	public void the_user_should_be_created_successfully() {
		
		//Console output of the response body and headers
		System.out.println(response.body().asPrettyString());
		System.out.println(response.getHeaders());
					
		//Asserting the response details
		Assert.assertEquals(response.getStatusCode(),201);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 201 Created");
		Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8");
		Assert.assertTrue(response.getTimeIn(TimeUnit.MILLISECONDS)<5000);
				
	}
	
	
	
	//Scenario 2 
	
	@Given("Verify the register unsuccessfull without using password")
	public void verify_the_register_unsuccessfull_without_using_password() {
		 HashMap<String, String> headers = new HashMap<String, String>();
		 headers.put("Content-Type","application/json");
		
		 JSONObject requestObject = new JSONObject();
		 requestObject.put( "email","sydney@fife");
		 
		 
		  apiPost = new APIRequest("post","/api/register",headers,requestObject);
	}

	@When("The admin user submits the user login details using missing password")
	public void the_admin_user_submits_the_user_login_details_using_missing_password() {
		 APIHelper apiHelper = new APIHelper();
		 response = apiHelper.hitAPI(apiPost);

	}

	@Then("The verification should be unsuccessfull")
	public void the_verification_should_be_unsuccessfull() {
		Assert.assertEquals(400, response.getStatusCode());
	}

	
	//Scenario 3 
	
	@Given("Enter the user details which needs to be created")
	public void enter_the_user_details_which_needs_to_be_created() {
		HashMap<String,String> metaInfo=new HashMap<String,String>();

		metaInfo.put("name", "silpa");
		metaInfo.put("job", "developer");
				
	 apiRequestPost = new APIRequest(
				"C:\\Users\\hp\\eclipse-workspace1\\API_Framework3_New\\src\\main\\java\\Files\\post.json",metaInfo);
	}

	@When("The admin user submit the request to create a user")
	public void the_admin_user_submit_the_request_to_create_a_user() {
		APIHelper apiHelper = new APIHelper();
	 response = apiHelper.hitAPI(apiRequestPost);
	}

	@Then("The new user should be created successfully")
	public void the_new_user_should_be_created_successfully() {
		
		Assert.assertEquals(201, response.getStatusCode());
	}
}
	
	