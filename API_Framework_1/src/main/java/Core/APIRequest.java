package Core;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class APIRequest {

	public String requestType;
	public String apiPath;
	public HashMap<String,String> headers;
	public JSONObject requestBody ;
	
	public String getRequestType() {
		return requestType;
	}
	public APIRequest(String requestType, String apiPath, HashMap<String, String> headers, JSONObject requestBody) {
		super();
		this.requestType = requestType;
		this.apiPath = apiPath;
		this.headers = headers;
		this.requestBody = requestBody;
	}
	public JSONObject getRequestBody() {
		return requestBody;
	}
	public void setRequestBody(JSONObject requestBody) {
		this.requestBody = requestBody;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getApiPath() {
		return apiPath;
	}
	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}
	
	
	
	public HashMap<String, String> getHeaders() {
		return headers;
	}
	public void setHeaders(HashMap<String, String> headers) {
		this.headers = headers;
	}
	
	
	public APIRequest(String requestType, String apiPath) {
		super();
		this.requestType = requestType;
		this.apiPath = apiPath;
	}
	
	public APIRequest(String requestType, String apiPath, HashMap<String, String> headers) {
		super();
		this.requestType = requestType;
		this.apiPath = apiPath;
		this.headers = headers;
	}
	
	

}
