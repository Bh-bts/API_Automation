package apiCollection;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.*;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class PostReq_POJO {
	
	@Test
	public void createUser() {
		
		POJO_PostReq Data = new POJO_PostReq();
		Data.setName("Bhavin");
		Data.setJob("QA");
		
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users";
		
		Response res = 
		
		(Response) given()
			.contentType(ContentType.JSON)
			.body(Data)
		.when()
			.post();
		
		System.out.println( res.getHeaders());
		System.out.println( res.getContentType());
		System.out.println(res.getBody().asPrettyString());
		
		
		
		
	}
	
	

}
