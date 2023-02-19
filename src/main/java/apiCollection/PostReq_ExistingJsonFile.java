package apiCollection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class PostReq_ExistingJsonFile {
	
	@Test
	public void login() throws FileNotFoundException {
		
		String projectpath = System.getProperty("user.dir");
		
		File file = new File(projectpath + "/src/main/java/apiCollection/login.json");
		FileReader reader = new FileReader(file);
		JSONTokener jt = new JSONTokener(reader);
		JSONObject js = new JSONObject(jt);
		
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api/login";
		
		Response res = (Response)
				
		given()
			.contentType(ContentType.JSON)
			.body(js.toString()) 
		.when()
			.post();
		
		System.out.println(res.getBody().asPrettyString());
		
		
		
		
	}

}
