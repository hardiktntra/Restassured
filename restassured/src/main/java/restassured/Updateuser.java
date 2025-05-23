package restassured;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Updateuser {

	public static void main(String[] args) {
		String baseURL="https://reqres.in";
		String uri="/api/users/2";
		
		String fullurl= baseURL + uri;
		
//		
//		Map<String, String> requestBody = new HashMap<>();
//        requestBody.put("name", "morpheus");
//        requestBody.put("job", "leader");
//  
//        
//		
//		Response res=RestAssured.given().contentType(ContentType.JSON).body(requestBody).when().put(fullurl);
		
		
		 RequestSpecification request = RestAssured.given();
	        
	        // Create JSON payload
	        JSONObject requestParams = new JSONObject();
	        requestParams.put("name", "morpheus ");
	        requestParams.put("job", "Wing commander");
	        
	        
	        // Convert JSONObject to String
	        request.body(requestParams.toString());
	        
	        // Set headers
	        request.header("Content-Type", "application/json");
	        request.header("x-api-key", "reqres-free-v1");
	        
	        
	        Response res = request.put(fullurl);
	        
	        
	        
	      
	        String fname = res.jsonPath().getString("name ");
	        String jobname = res.jsonPath().getString("job ");
	      //  String createdAt = response.jsonPath().getString("createdAt");
	        
	       
	        System.out.println("Firstname is" +fname);
	        System.out.println("Updated job is: " +jobname);
	       

	        
	        // Print response
	        System.out.println("\n Status Code: " + res.getStatusCode());
	        System.out.println("---> Response JSON Body: " + res.getBody().asString());
	        
	}

}
