package praticePacakge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

/**
 * @author Bhavin.Thumar
 *
 */

public class PostEReq_ExistJSON {
	
	@Test
	public void login() throws FileNotFoundException {
		
		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath + "/src/main/java/praticePacakge/login.json");
		FileReader reader = new FileReader(file);
		JSONTokener jt = new JSONTokener(reader);
		JSONObject Data = new JSONObject(jt);
		
		RestAssured.baseURI = "http://103.138.234.244:9067";
		RestAssured.basePath = "/api/Login/Login";
		
		Response res = (Response)
		
		given()
			.body(Data.toString())
		.when()
			.post();
		
		//System.out.println(res.getBody().asPrettyString());
		
		String get = res.getBody().asPrettyString();
		JsonPath js = new JsonPath(get);
		String a = js.get("data.refreshToken");
		
		System.out.println(a);
		
	}

}
