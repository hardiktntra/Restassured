package restassured;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Registeruser {

	public static void main(String[] args) {
		String baseURL="https://reqres.in";
		String uri="/api/register";
		
		String fullurl= baseURL + uri;
		
		 RequestSpecification request = RestAssured.given();
	        
	        // Create JSON payload
	        JSONObject requestParams = new JSONObject();
	        requestParams.put("email", "eve.holt@reqres.in");
	        requestParams.put("password", "pistol");
	        
	        
	        // Convert JSONObject to String
	        request.body(requestParams.toString());
	        
	        // Set headers
	        request.header("Content-Type", "application/json");
	        request.header("x-api-key", "reqres-free-v1");
	        
	        
	        Response res = request.post(fullurl);
	        
	        int scode=res.getStatusCode();
	        
	        System.out.println(scode);
	        
	        
	        String id = res.jsonPath().getString("id");
	        String token = res.jsonPath().getString("token");
	        
	        System.out.println("Registered id "+id);
	        System.out.println("registered token "+token);
	        
	        
	        
	        
	        
	}
}

	        
	        