package apiCollection;

import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class PostReq_OrgJson {

	@Test
	public void register() {
		
		JSONObject Data = new JSONObject();
		Data.put("email", "eve.holt@reqres.in");
		Data.put("password", "pistol");
		
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api/register";
		
		Response res = (Response)
				
		given()
			.body(Data.toString())
			.contentType(ContentType.JSON)
		.when()
			.post();
		
		System.out.println(res.getBody().asPrettyString());
		System.out.println("Status code is : " + res.statusCode());
		
		String jsonBody = res.getBody().asPrettyString();
		
		JsonPath json = new JsonPath(jsonBody);
		String token = json.get("token");
		System.out.println(token);
		
	}
	
}
