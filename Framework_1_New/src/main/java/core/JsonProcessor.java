package core;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.HashMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


public class JsonProcessor {
	
	
	public static String jsonObjectToString(JSONObject jsonObj) {
		
		return jsonObj.toJSONString();	
	}
		
	
	public static JSONObject stringToJsonObject(String inputString) {
		JSONObject jsonObj= new JSONObject();
		
		JSONParser parser = new JSONParser();
		try {
			 jsonObj = (JSONObject) parser.parse(inputString);
			 System.out.println(jsonObj.getClass());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObj;
		
	}

	
	public static JSONObject readFromJsonFile(String filePath)  {
		
		JSONParser parser = new JSONParser();
		FileReader fileReader;
		JSONObject jsonObject=null;
		try {
			fileReader = new FileReader(filePath);
			 jsonObject=(JSONObject) parser.parse(fileReader);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return jsonObject;		
	}
	
	
	public static HashMap<String, Object> getJsonAsObjectMap(String toJSONString) {
        HashMap<String,Object> objectMap = new Gson().fromJson(toJSONString, HashMap.class);
        return  objectMap;
    }
		
	}



