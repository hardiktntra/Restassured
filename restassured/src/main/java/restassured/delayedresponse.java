package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class delayedresponse {

	public static void main(String[] args) {
		
		  String baseurl = "https://reqres.in";
	      String strURITokenForget = "/api/users?delay=3"; // Make sure to include /api/
	      String fullUrl = baseurl + strURITokenForget;
	      
	      
	      Response res= RestAssured.given().header("x-api-key", "reqres-free-v1").when().get(fullUrl);
	      
	      int status= res.getStatusCode();
	      System.out.println(status);
	      
	      String responseBody = res.getBody().asString();
	      
	  //    System.out.println(responseBody);
	      
	      System.out.println("Status Code: " + status);
	      System.out.println("Response Body:\n" + responseBody);
	}

}
