package jsonschemaValidator;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.API.utils.PropertiesClass;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

public class CommentsPost extends PropertiesClass{
	
	@Test
	public void commentPostval() throws IOException {
		
		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath + "/JSONSchema/CommentPostJSON_schema.json");
		
		RestAssured.baseURI = PropertiesClass.setCommentPost_baseURI();
		RestAssured.basePath = PropertiesClass.setCommnetPost_basePath();
		
		given()
			.accept("Application/json")
			.header("Application","json")
			.queryParam(PropertiesClass.setCommentPost_query())
		.when()
			.get()
		.then()
			.assertThat()
			.body(JsonSchemaValidator.matchesJsonSchema(file));

	}

}
