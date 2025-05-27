package restassured;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class loginfailed {

	public static void main(String[] args) {
		String baseURL="https://reqres.in";
		String uri="/api/login";
		
		String fullurl= baseURL + uri;
		
		 RequestSpecification request = RestAssured.given();
	        
	        // Create JSON payload
	        JSONObject requestParams = new JSONObject();
	        requestParams.put("email", "peter@klaven");
	       
	       
	        
	        
	        // Convert JSONObject to String
	        request.body(requestParams.toString());
	        
	        // Set headers
	        request.header("Content-Type", "application/json");
	        request.header("x-api-key", "reqres-free-v1");
	        
	        
	        Response res = request.post(fullurl);
	        
	        int scode=res.getStatusCode();
	        
	        System.out.println(scode);
	        
	        
	        String token = res.jsonPath().getString("error");

	        
	        System.out.println("Error message "+token);


	}

}
