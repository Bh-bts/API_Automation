package apiCollection;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FirstGetAPI {

	@Test(enabled = false)
	public void getMethod() {
		
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api/users/{id}";
		
							given() 
								.queryParam("page", "2")
								.header("Accept", "application/json")
								.pathParam("id", 7)
								.log()
								.all()
							.when()
								.get()
							.then()
							 	.statusCode(200)
							    .body(containsString("Michael")); 
								
	}
	
	@Test(enabled = false)
	public void getMethod2() {
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RestAssured.basePath = "/posts/{id}/comments";
		
		given()
			.header("Accept","application/json")
			.pathParam("id", 1)
			.log()
			.all()
		.when()
			.get()
		.then()
			.body(containsString("id labore ex et quam laborum"));
	}
	
	@Test(enabled = false)
	public void getMethod3() {
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RestAssured.basePath = "/comments";
		
		given()
			.queryParam("postId", 1)
			.header("accept", "application/xml")
			.log()
			.all()
		.when()
			.get()
		.then()
			.statusCode(200);
		
	}
	
	@Test
	public void getMethod4() {
		
		RestAssured.baseURI = "https://dummyjson.com/";
		RestAssured.basePath = "/products/{id}";
		
		given()
			.header("Accept", "application/json")
			.contentType(ContentType.JSON)
			.pathParam("id", 2)
			.cookie("session_id", "1234")
			.log()
			.all()
		.when()
			.get()
		.then()
			.statusCode(200)
			.body("title", equalTo("iPhone X"));
		
	}
	
}
