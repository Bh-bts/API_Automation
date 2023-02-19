package jsonschemaValidator;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.API.utils.PropertiesClass;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.given;


public class CreateUser extends PropertiesClass{
	
	@Test
	public void createUserjsonSchema() throws IOException {
		
		RestAssured.baseURI= PropertiesClass.setCreteAPI_baseURI();
		RestAssured.basePath = PropertiesClass.setCreteAPI_basePath();
		
		String projectpath = System.getProperty("user.dir");
		File jsonFile = new File(projectpath + "/JSONSchema/CreateJSON_schema.json");
		
		given()
			.contentType("application/json")
			.header("Application","json")
		.when()
			.get()
		.then()
			.assertThat()
			.body(JsonSchemaValidator.matchesJsonSchema(jsonFile))
			.statusCode(200)
			.log()
			.all();
	}

}
