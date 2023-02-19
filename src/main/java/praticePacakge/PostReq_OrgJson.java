package praticePacakge;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class PostReq_OrgJson {
	
	@Test
	public void login() {
		
		
		JSONObject Data = new JSONObject();
		Data.put("empno", "100999");
		Data.put("password", "Admin@1234");
		
		RestAssured.baseURI = "http://103.138.234.244:9067";
		RestAssured.basePath = "/api/Login/Login";
		
		given()
			.body(Data.toString())
		.when()
			.post();
		
	}

}
