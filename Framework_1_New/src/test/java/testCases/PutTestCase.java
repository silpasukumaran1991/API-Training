package testCases;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.APIHelper;
import core.APIRequest;
import io.restassured.response.Response;

public class PutTestCase {
	APIHelper apiHelper = new APIHelper();
	///testcase13
	@Test(enabled = true)
	
	 public void testUpdateUserDetails() {
	HashMap<String, String> headers = new HashMap<String, String>();
	headers.put("Content-Type", "application/json");
	JSONObject requestObject = new JSONObject();
	requestObject.put("name","morpheus");
	requestObject.put("job","zion resident1");
	APIRequest apiRequestPut = new APIRequest("put","/api/users/2",headers,requestObject);
	Response response = apiHelper.hitAPI(apiRequestPut);
	Assert.assertEquals(200, response.getStatusCode());

}
}
