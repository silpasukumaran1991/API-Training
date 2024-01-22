package core;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class sampleApiRequest {
	public String requestType;
	public String apiPath;
	public HashMap<String,String> headers;
	public JSONObject requestBody ;
	public String getRequestType() {
		return requestType;
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
	public JSONObject getRequestBody() {
		return requestBody;
	}
	public void setRequestBody(JSONObject requestBody) {
		this.requestBody = requestBody;
	}


}
