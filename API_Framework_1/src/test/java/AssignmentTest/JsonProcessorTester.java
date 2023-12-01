package AssignmentTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import Core.JsonProcessor;
import Core.randomData;
import junit.framework.Assert;

public class JsonProcessorTester {
	
	
  @Test
  public void convertJsonObjToString() {
	  
	  
	  	JSONObject root = new JSONObject();
		JSONObject address = new JSONObject();
	  
		root.put("name", "Ajith");
		root.put("age", 29);
		root.put("isEmployed", true);
		root.put("Height", 176.0f);
		
		//adding values to address object
		address.put("housename","abcd" );
		address.put("city", "trivandrum");
		address.put("pincode", 695582);
		
		
		//adding address object to root object
		root.put("address", address);
	  
	  
		String actualJsonString = JsonProcessor.jsonObjectToString(root);
		System.out.println(actualJsonString);
		
		String expectedJsonString="{\"address\":{\"pincode\":695582,\"housename\":\"abcd\",\"city\":\"trivandrum\"},\"name\":\"Ajith\",\"Height\":176.0,\"isEmployed\":true,\"age\":29}";
		
		Assert.assertEquals(actualJsonString, expectedJsonString);
		
		
		
	  
  }
  
  
  @Test(enabled = false )
  public void convertStringToJsonObj() {
	  
	  	JSONObject root = new JSONObject();
	//	JSONObject address = new JSONObject();
	  
		root.put("name", "Ajith");
		root.put("age", 29);
	/*	root.put("isEmployed", true);
		root.put("Height", 176.0f);
		
		//adding values to address object
		address.put("housename","abcd" );
		address.put("city", "trivandrum");
		address.put("pincode", 695582);
		
		
		//adding address object to root object
		root.put("address", address);   */
	  
		String jsonString=JsonProcessor.jsonObjectToString(root);
  
		
		//JSONObject expectedObj = root;
		JSONObject actualObj= JsonProcessor.stringToJsonObject(jsonString);
		
		System.out.println(actualObj.getClass());
		Assert.assertEquals(actualObj, root);
			  
  }
	  
  @Test(enabled=false)
  public void verifyRandomData() {
	  randomData email = new randomData();
	  email.getRandomEmail();
	  
  }
  
  @Test
  public void verifyRandomData1() {
	  randomData address = new randomData();
	  address.getRandomAddress();
	  
  }
  
  
}