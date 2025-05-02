package restassured;

import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class apitest {
    
    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in/";
        String strURITokenForPost = "api/users";
        
        RequestSpecification request = RestAssured.given();
        
        // Create JSON payload
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "morpheus");
        requestParams.put("job", "leader");
        
        
        // Convert JSONObject to String
        request.body(requestParams.toString());
        
        // Set headers
        request.header("Content-Type", "application/json");
        request.header("x-api-key", "reqres-free-v1");
        
        // Send POST request
        Response response = request.post(strURITokenForPost);
        String id = response.jsonPath().getString("id");
        String createdAt = response.jsonPath().getString("createdAt");
        
        System.out.println("Extracted ID: " + id);
        System.out.println("Created At: " + createdAt);

        
        // Print response
        System.out.println("\n Status Code: " + response.getStatusCode());
        System.out.println("---> Response JSON Body: " + response.getBody().asString());
    }
}
