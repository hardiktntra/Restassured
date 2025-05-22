package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getusers {

    public static void main(String[] args) {
        String baseurl = "https://reqres.in";
        String strURITokenForget = "/api/users?page=2"; // Make sure to include /api/
        String fullUrl = baseurl + strURITokenForget;

        // Send GET request and store the response
        Response response = RestAssured
                .given()
                .header("x-api-key", "reqres-free-v1") // This header is optional for ReqRes
                .when()
                .get(fullUrl);

        // Get status code
        int statusCode = response.getStatusCode();

        // Get response body as string
        String responseBody = response.getBody().asString();

        // Print results
        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Body:\n" + responseBody);
        
        
    }
}