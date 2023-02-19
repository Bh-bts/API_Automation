package apiCollection;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.List;
import org.testng.annotations.Test;

/**
 * @author Bhavin.Thumar
 *
 */

public class GetReq {
	
	
	@Test
	public void posts() {
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RestAssured.basePath = "/posts";
		
		Response res = (Response)
		
		given()
		.when()
			.get();
			
		String data = res.getBody().asPrettyString();
		JsonPath js = new JsonPath(data);
		
		List<String> title = js.getList("title");
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<title.size();i++) {
		
		sb.append(i).append(": ").append(title.get(i)).append("\n");
			
		}
		String con = sb.toString();
		System.out.println(con);
		
	}

}
