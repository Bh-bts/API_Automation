package jsonschemaValidator;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.io.File;
import org.testng.annotations.Test;

public class SingleUser {
	
	@Test
	public void singleUser() {
		
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "api/unknown/2";
		
		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath + "/JSONSchema/SingleUserJSON_schema.json");
		
		Response res =
		
		 given()
			.contentType(ContentType.JSON)
		.when()
			.get()
		.then()
			.extract()
			.response();
		
	  res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));
		
	}
	

}
