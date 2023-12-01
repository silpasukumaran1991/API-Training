package Assignments;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Assignment3 {
	public static void createJSonObject() {
		JSONObject root = new JSONObject();
		JSONObject address = new JSONObject();
		
		//adding values to root object
		root.put("name", "Silpa");
		root.put("age", 30);
		root.put("isEmployed", true);
		root.put("Height", 154.0f);
		
		//adding values to address object
		address.put("housename","abcd" );
		address.put("city", "kochi");
		address.put("pincode", 686576);
		
		
		//adding address object to root object
		root.put("address", address);
		
		//printing values 
		
	//	System.out.println(root.get("age"));
	//	System.out.println(root.get("address"));
	//	System.out.println(address.get("city"));
		//System.out.println(root.toString());	
//		System.out.println(root.get("name"));	
		//System.out.println(root.get("address"));
		System.out.println(root.toJSONString());

		
		
		
		ObjectMapper om = new ObjectMapper();
		try {
			Root root2 = om.readValue(root.toString(), Root.class);
			
			System.out.println(root2.getAddress().getHousename());		
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			
		}

	}
	
	
	public static void main(String[] args) {
		createJSonObject();
		
	}

}