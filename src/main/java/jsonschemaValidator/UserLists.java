package jsonschemaValidator;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.API.utils.PropertiesClass;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

public class UserLists extends PropertiesClass{
	
	@Test
	public void userListjsonSchema() throws IOException {
		
		RestAssured.baseURI = PropertiesClass.setUserList_baseURI();
		RestAssured.basePath = PropertiesClass.setUserList_basePath();
		
		String projectPath = System.getProperty("user.dir");
		
		File file = new File(projectPath + "/JSONSchema/UserListsJSON_schema.json");
		
		given()
			.pathParam("id", 1)
		.when()
			.get()
		.then()
			.assertThat()
			.body(JsonSchemaValidator.matchesJsonSchema(file));
		
	}

}
