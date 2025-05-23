package restassured;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class deleteuser {

	public static void main(String[] args) {
		String baseURL="https://reqres.in";
		String uri="/api/users/2";
		
		String fullurl= baseURL + uri;
		
	
	        
	        
	        Response res = RestAssured.given().header("x-api-key", "reqres-free-v1").when().delete(fullurl);
	        
	        
	        // Print response
	        System.out.println("\n Status Code: " + res.getStatusCode());
	        System.out.println("---> Response JSON Body: " + res.getBody().asString());
	        
	  
	        


	       
	        

	}

}
